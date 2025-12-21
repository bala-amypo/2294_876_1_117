package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    // Create user (POST)
    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    // Get user by ID (GET)
    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Get all users (GET)
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }
}
