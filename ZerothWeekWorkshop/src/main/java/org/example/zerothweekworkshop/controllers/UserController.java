package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.models.Movie;
import org.example.zerothweekworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{id}/savePreference")
    public String savePreferences(@ModelAttribute Movie movieToSave) {
        if (movieToSave!=null) {
     //       userService.saveMovies();
        }
        return "index";
    }

}
