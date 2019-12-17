package com.kostya.moneycontrol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/getRendered")
    public String getRenderedByThymeleaf(Model model) {
        model.addAttribute("string_for_template", "Hello world!");
        return "hello-page";
    }
}
