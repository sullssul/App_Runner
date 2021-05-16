package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.runner.entity.User;
import ru.runner.service.UserService;


@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "profile";
    }

}
