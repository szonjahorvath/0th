package org.example.zerothweekworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/singup")
    public String singup() {
        return "singup";
    }
}
