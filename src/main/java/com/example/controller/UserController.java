package com.example.controller;

import com.example.entities.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

}
