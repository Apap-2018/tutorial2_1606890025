package com.example.demo.tutorial_2.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @RequestMapping("/viral")
    public String index() {
        return "viral";
    }

    @RequestMapping("/challenge")
    public String challange(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping(value = { "/challenge" , "/challenge/{name}" })
    public String challangePath(@PathVariable Optional<String> name, Model model) {
        if (name.isPresent()) {
            model.addAttribute("name", name.get());
        } else {
            model.addAttribute("name", "KB");
        }
        return "challenge";
    }
}