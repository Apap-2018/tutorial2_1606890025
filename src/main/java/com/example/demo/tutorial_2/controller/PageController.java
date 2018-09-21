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

    @RequestMapping("/generator")
    public String viralGenerator(
        @RequestParam(value = "a", required = false, defaultValue = "0") int a,
        @RequestParam(value = "b", required = false, defaultValue = "0") int b,
        Model model) {
            String result = "h" + new String(new char[a<1?1:a]).replace("\0", "m") + " ";
            result = new String(new char[b<1?1:b]).replace("\0", result);
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("result", result);
            return "viralGenerator";
        }
        
}