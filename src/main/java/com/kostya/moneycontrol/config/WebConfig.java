package com.kostya.moneycontrol.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.kostya.moneycontrol.controllers")
public class WebConfig {
}
