package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.models.Movie;
import org.example.zerothweekworkshop.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MovieService movieService;

    //to review
    @GetMapping("/content/{id}/savePreference")
    public String getPreference(@PathVariable Long id, Model model){

        System.out.println(movieService.findMovieById(id));
        return "redirect:user/content";
    }
//    @PostMapping("/content/{id}/savePreference")
//    public String savePreferences(@ModelAttribute Movie movieToSave) {
//        if (movieToSave != null) {
//            Movie preference=new Movie();
//            preference.setTitle(movieToSave.getTitle());
//            //   preference.setOverview(movieToSave.getOverview());
//            preference.setPopularity(movieToSave.getPopularity());
//            movieService.saveMovie(movieToSave);
//        }
//        return "redirect:user/content";
//    }

}
