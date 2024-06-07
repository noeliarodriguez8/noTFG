package com.memeov1.memeov1.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello, world!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello, user!";
    }

}
