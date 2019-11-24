package com.kostya.moneycontrol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello, World!";
    }
}
