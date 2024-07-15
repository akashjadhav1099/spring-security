package com.example.service;

import com.example.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list= new ArrayList<>();

    public UserService(){
        list.add(new User("akash10", "Akash123","jadhav.akash@gmail.com"));
        list.add(new User("vamshi27", "Vamshi123","vamshi.vupulla@gmail.com"));

    }

    public List<User> getAllUsers(){
        return this.list;
    }

    public User getUser(String username){
        return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public  User addUser(User user){
        this.list.add(user);
        return user;
    }
}
