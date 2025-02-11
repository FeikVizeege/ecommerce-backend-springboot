package com.group.ecommerce_backend_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello! This is Spring Boot";
    }
}
