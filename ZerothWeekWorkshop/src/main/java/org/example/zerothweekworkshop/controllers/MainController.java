package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage(@RequestParam(value = "logout", required = false) String logout) {
        return "index";
    }

    @GetMapping("/user/content")
    public String content(Model model) {
        model.addAttribute("movies", userService.loadMovies());
        System.out.println(userService.loadMovies().toString());
        return "content";
    }


    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

}
