package com.kostya.moneycontrol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello, World!";
    }
}
