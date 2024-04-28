package org.example.zerothweekworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/content")
    public String content() {
        return "content";
    }


    @GetMapping("/login")
    public String loginForm(@RequestParam(value = "logout", required = false) String logout) {
        return "login";
    }

 /*   @GetMapping("/login")
    public String loginForm(){
        return "login";
    }*/
}
