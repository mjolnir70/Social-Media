package com.example.springboottwittercloneapplication.controller;


import com.example.springboottwittercloneapplication.dto.UserDto;
import com.example.springboottwittercloneapplication.model.User;
import com.example.springboottwittercloneapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
        return userService.login(userDto.getEmail(), userDto.getPassword());
        //return userService.login(body.get("email"), body.get("password"));
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserDto userDto) {
        return userService.signup(userDto.getEmail(), userDto.getName(), userDto.getPassword());
        //return userService.signup(body.get("email"), body.get("name"), body.get("password"));
    }

    @GetMapping("/user")
    public Object getUser(@RequestParam Long userID) {
        Optional<User> userOptional = userService.getUserbyId(userID);
        return userOptional.isPresent() ? userOptional.get() : "user not found";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
