package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.runner.entity.Project;
import ru.runner.entity.ProjectConfig;
import ru.runner.entity.User;
import ru.runner.service.ProjectConfigService;
import ru.runner.service.ProjectService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectConfigService configService;


    @GetMapping("/allProjects")
    public String showAllProjects(Model model) {
        List<Project> projectList = projectService.getAllProjects();
        model.addAttribute("projectList", projectList);

        return "project/all_projects";
    }

    @GetMapping("/project/{id}")
    public String showProject(Model model, @PathVariable("id") long id) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "project/project";
    }


    @GetMapping("/project/create")
    public String createProject(Model model) {
        List<ProjectConfig> configList = configService.getAllConfigs();

        model.addAttribute("configList", configList);
        model.addAttribute("projectForm", new Project());
        model.addAttribute("isEdit", false);

        return "project/edit_project";
    }

    @PostMapping("/project/create")
    public String createProject(@ModelAttribute("projectForm") @Valid Project project,
                                BindingResult bindingResult,
                                Model model) throws Exception {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        project.setUser(user);
        project.setCreatingDate(new Date());
        project.setLogo("");

        if (bindingResult.hasErrors()) {
            throw new Exception("Не удалось создать проект, обратитесь к администратору. " + bindingResult.toString());
        }

        projectService.addNewProject(project);

        return "redirect:/allProjects";
    }

    @GetMapping("/project/edit/{id}")
    public String showEditProjectForm(Model model, @PathVariable("id") long id) {

        Project project = projectService.getProjectById(id);
        model.addAttribute("projectForm", project);
        model.addAttribute("configList", configService.getAllConfigs());
        model.addAttribute("isEdit", true);
        return "project/edit_project";
    }

    @PostMapping("/project/edit/{id}")
    public String updateProject(@ModelAttribute("projectForm") @Valid Project projectForm,
                                @PathVariable("id") long id,
                                BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            throw new Exception("Не удалось обновить проект, обратитесь к администратору. " + bindingResult.toString());
        }

        projectService.updateProject(projectForm);

        return "redirect:project/project/{" + id + "}";
    }
}
