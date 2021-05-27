package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.runner.entity.ProjectConfig;
import ru.runner.service.LanguageAndBuilderService;
import ru.runner.service.ProjectConfigService;
import ru.runner.service.ProjectService;
import ru.runner.service.UserService;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectConfigService configService;

    @Autowired
    private LanguageAndBuilderService languageAndBuilderService;

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


    @GetMapping("/admin/configs")
    public String showConfig(Model model) {
        model.addAttribute("configList", configService.getAllConfigs());
        return "configs_manage";
    }

    @GetMapping("/admin/configs/create")
    public String createConfig(Model model) {
        model.addAttribute("configForm", new ProjectConfig());
        model.addAttribute("languageList", languageAndBuilderService.getAllLanguages());

        return "create_config";
    }

    @PostMapping("/admin/configs/create")
    public String createConfigSelectBuilder(@ModelAttribute("configForm") @Valid ProjectConfig config,
                                            Model model) {

        long langId = config.getLanguage().getId();

        model.addAttribute("builderList", languageAndBuilderService.getBuildersForLanguage(langId));
        model.addAttribute("configForm", config);

        return "create_config_select_builder";
    }

    @PostMapping("/admin/configs/builder")
    public String saveNewConfig(@ModelAttribute("configForm") @Valid ProjectConfig config,
                                Model model) {

        boolean isEmptyBuilder = config.getBuilder() == null;

        if (!isEmptyBuilder) {
            config.setLanguage(config.getBuilder().getLanguage());
            config.generateName();
            configService.addNewConfig(config);
        }

        return "redirect:/admin/configs";
    }

    @PostMapping("/admin/configs/delete")
    public String deleteConfig(@RequestParam(required = true, defaultValue = "") Long configId,
                               Model model) {

        if (configId != null) {
            configService.deleteConfig(configId);
        }

        return "redirect:/admin/configs";
    }

    @GetMapping("/admin/languages")
    public String languageList(Model model) {
        model.addAttribute("langList", languageAndBuilderService.getAllLanguages());

        return "language_manage";
    }

    @GetMapping("/admin/builders")
    public String builderList(Model model) {
        model.addAttribute("builderList", languageAndBuilderService.getAllBuilders());

        return "builder_manage";
    }

    @PostMapping("/admin/builders/delete")
    public String deleteBuilder(@RequestParam(required = true, defaultValue = "") Long builderId,
                               Model model) {

        if (builderId != null) {
            languageAndBuilderService.deleteBuilder(builderId);
        }

        return "redirect:/admin/builders";
    }

    @PostMapping("/admin/languages/delete")
    public String deleteLanguage(@RequestParam(required = true, defaultValue = "") Long langId,
                               Model model) {

        if (langId != null) {
            languageAndBuilderService.deleteLanguage(langId);
        }

        return "redirect:/admin/languages";
    }
}

