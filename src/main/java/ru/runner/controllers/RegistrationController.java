package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.runner.entity.User;
import ru.runner.service.UserService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "/profile/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
                          BindingResult bindingResult,
                          Model model) {

        userForm.setRegisteringDate(new Date());
        userForm.setShortMemo("");
        userForm.setPhoto("/images/empty.png");

        if (bindingResult.hasErrors()) {
            return "/profile/registration";
        }

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "/profile/registration";
        }

        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "/profile/registration";
        }

        return "redirect:/";
    }
}