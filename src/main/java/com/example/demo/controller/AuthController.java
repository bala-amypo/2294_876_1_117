package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserAccount user) {
        userService.createUser(user); // dummy call
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        userService.findByUsername(user.getUsername()); // dummy call
        return "Logged in successfully";
    }
}