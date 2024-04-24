package org.example.zerothweekworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    public String mainPage() {
        return "index";
    }
}
