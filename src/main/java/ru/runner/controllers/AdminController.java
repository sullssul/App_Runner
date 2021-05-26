package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.runner.service.ProjectService;
import ru.runner.service.UserService;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/admin/users")
    public String userList(Model model) {
        model.addAttribute("userList", userService.allUsers());
        return "users";
    }

    @GetMapping("/admin/projects")
    public String projectList(Model model) {
        model.addAttribute("projectList", projectService.getAllProjects());
        return "projects_manage";
    }

    @PostMapping("/admin/users/delete")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             Model model) {

        if (userId != null) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/project/delete")
    public String deleteProject(@RequestParam(required = true, defaultValue = "") Long projectId,
                             Model model) {

        if (projectId != null) {
            projectService.deleteProject(projectId);
        }
        return "redirect:/admin/projects";
    }


    @GetMapping("/admin/gt/{userId}")
    public String gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }
}

