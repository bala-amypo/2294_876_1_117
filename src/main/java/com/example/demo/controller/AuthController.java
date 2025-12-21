package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")  // Allow Swagger / browser access
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    // Simple login check (POST)
    @PostMapping("/login")
    public UserAccount login(@RequestParam String username, @RequestParam String email) {
        UserAccount user = userService.findByUsername(username);

        if (!user.getEmail().equals(email)) {
            throw new BadRequestException("Invalid email for the given username");
        }

        return user;  // Login successful
    }
}
