package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.configurations.JwtTokenUtil;
import org.example.zerothweekworkshop.dto.UserDTO;
import org.example.zerothweekworkshop.models.User;
import org.example.zerothweekworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainApiController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User user) {
        return service.addUser(user);
    }

    /* For Postman in the JSON body:

    {
  "name": "user",
  "password": "password",
  "roles": "ROLE_USER"
}

    */

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String AuthenticateAndGetToken(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.getUsername(),
                userDTO.getPassword()
        ));
        if (authentication.isAuthenticated()) {
            return tokenUtil.generateToken(userDTO.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    /*
    Checking in with postman:

    {
  "username": "user",
  "password": "password"
} --> should generate a token like "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzE0MzA3NjU1LCJleHAiOjE3MTQzMDk0NTV9.9xBDRut3Jm2q9LmW99ecz0zrvhXwPqk4ILuC4qpXcfE"
     */
}
