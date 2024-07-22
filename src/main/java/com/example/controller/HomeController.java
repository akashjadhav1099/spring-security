package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
//@EnableMethodSecurity
public class HomeController {

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/home")
    public String home(){
        return "this is home page";
    }

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/login")
    public String login(){
        return "this is login page";
    }

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/register")
    public String register(){
        return "this is register page";
    }
}
