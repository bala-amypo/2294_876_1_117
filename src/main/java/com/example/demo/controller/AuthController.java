package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserAccount registerUser(@RequestBody UserAccount user) {
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userService.create(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String usernameOrEmail,
                            @RequestParam String password) {

        Optional<UserAccount> userOpt = userService.findByUsername(usernameOrEmail);
        if (userOpt.isEmpty()) {
            return "User not found";
        }

        UserAccount user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            return "Invalid password";
        }

        return "Login successful for user: " + user.getUsername();
    }
}