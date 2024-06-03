package com.example.springboottwittercloneapplication.service;


import com.example.springboottwittercloneapplication.model.User;
import com.example.springboottwittercloneapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword().equals(password)){
                return "Logged in successfully";
            }
            else{
                return "Wrong email/password";
            }
        }
        else{
            return "User not found";
        }
    }

    public String signup(String email, String name, String password) {
        if(userRepository.findByEmail(email).isPresent()){
            return "User already exists";
        }
        else{
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);
            userRepository.save(user);
            return "User created successfully";
        }
    }

    public Optional<User> getUserbyId(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
