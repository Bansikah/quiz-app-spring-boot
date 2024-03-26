package com.bansikah.quizapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

    @RequestMapping
    public String home() {
        return "This is the home page for my quiz application";
    }
}
