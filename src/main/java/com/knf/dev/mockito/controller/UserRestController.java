package com.knf.dev.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.knf.dev.mockito.entity.User;
import com.knf.dev.mockito.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/save")
    public User updating(@RequestBody User s){
        return userService.updating(s);
    }
    @DeleteMapping("/delete/{city}")
    public String deleteUser(@PathVariable User u){
        return userService.deleteUser();
    }
}
