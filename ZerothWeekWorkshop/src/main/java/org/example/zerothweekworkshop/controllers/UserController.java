package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.models.Movie;
import org.example.zerothweekworkshop.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/{id}/savePreference")
    public String savePreferences(@ModelAttribute Movie movieToSave) {
        if (movieToSave != null) {
            movieService.saveMovie(movieToSave);
        }
        return "redirect:user/content";
    }

}
