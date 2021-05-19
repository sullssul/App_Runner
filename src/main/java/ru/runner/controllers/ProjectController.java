package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.runner.entity.Project;
import ru.runner.service.ProjectService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/allProjects")
    public String showAllProjects(Model model) {
        List<Project> projectList = projectService.getAllProjects();
        model.addAttribute("projectList", projectList);

        return "all_projects";
    }

    @GetMapping("/project/{id}")
    public String showProject(Model model, @PathVariable("id") long id) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "project";
    }

    @GetMapping("/project/create")
    public String showProject(Model model) {
        model.addAttribute("projectForm", new Project());
        return "create_project";
    }

    @GetMapping("/project/edit/{id}")
    public String showEditProjectForm(Model model, @PathVariable("id") long id) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("isNewProject", false);
        model.addAttribute("project", project);

        return "edit_project";
    }

    @PostMapping("/project/edit/{id}")
    public String editProject(@ModelAttribute("projectForm") @Valid Project projectForm,
                              @PathVariable("id") long id) {

//        Project project = projectService.getProjectById(id);
//        model.addAttribute("project", project);

        return "project";
    }


}
