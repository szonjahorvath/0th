package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.models.User;
import org.example.zerothweekworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.zerothweekworkshop.models.Movie;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") User user) {
        user.setRoles("ROLE_USER");
        userService.addUser(user);
        return "redirect:/login";

    @PostMapping("/{id}/savePreference")
    public String savePreferences(@ModelAttribute Movie movieToSave) {
        if (movieToSave!=null) {
     //       userService.saveMovies();
        }
        return "index";
    }

}
