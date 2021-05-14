package ru.runner.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

    @GetMapping("/hello")
    public String helloPage() {
        return "hello/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "hello/goodbye";
    }
}
