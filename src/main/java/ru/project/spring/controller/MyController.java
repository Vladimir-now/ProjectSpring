package ru.project.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MyController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello, guest!");
        return "index";
    }
}
