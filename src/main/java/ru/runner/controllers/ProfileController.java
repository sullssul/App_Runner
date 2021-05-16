package ru.runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.runner.entity.User;
import ru.runner.service.UserService;

import javax.validation.Valid;


@Controller
public class ProfileController {

    @Autowired
    private UserService userService;


    @RequestMapping("/profile")
    public ModelAndView showProfile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @GetMapping("/profile/editprofile/{id}")
    public String showEditProfileForm(Model model, @PathVariable("id") long id) {
        User user = userService.findUserById(id);
        model.addAttribute("userForm", user);

        return "editprofile";
    }


    @PostMapping("/profile/editprofile/{id}")
    public ModelAndView editProfile(@ModelAttribute("userForm") @Valid User userForm,
                                    @PathVariable("id") long id,
                                    BindingResult bindingResult,
                                    Model model) {

        User user = userService.findUserById(id);
        model.addAttribute("userForm", user);
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            setErrorUrl(id, modelAndView);
            return modelAndView;
        }

        boolean notEqualsPasswords = !userForm.getPassword().equals(userForm.getPasswordConfirm());

        if (notEqualsPasswords) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            setErrorUrl(id, modelAndView);
            return modelAndView;
        }

        boolean isNewUserName = userForm.getUsername().equals(user.getUsername());
        boolean userNameAlreadyExist = !userService.saveUser(userForm);

        if (userNameAlreadyExist && !isNewUserName) {
            model.addAttribute("usernameError", "Данный логин занят!");
            setErrorUrl(id, modelAndView);
            return modelAndView;
        }

        copyEmptyParams(user, userForm);
        userService.updateUser(userForm);
        modelAndView.setViewName("redirect:/profile");

        return modelAndView;
    }

    private void setErrorUrl(long id, ModelAndView modelAndView) {
        String errorUrl = "redirect:profile/editprofile/" + id;
        modelAndView.setViewName(errorUrl);
    }

    private User copyEmptyParams(User user, User userForm) {
        if (userForm.getUsername() == null) {
            userForm.setUsername(user.getUsername());
        }

        if (userForm.getRegisteringDate() == null) {
            userForm.setRegisteringDate(user.getRegisteringDate());
        }

        if (userForm.getPhoto() == null) {
            userForm.setPhoto(user.getPhoto());
        }

        if (userForm.getRoles() == null) {
            userForm.setRoles(user.getRoles());
        }

        return userForm;
    }

}
