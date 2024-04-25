package org.example.zerothweekworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(@RequestParam(value = "logout", required = false) String logout) {
        return "index";
    }

    @GetMapping("/content")
    public String content() {
        return "content";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
