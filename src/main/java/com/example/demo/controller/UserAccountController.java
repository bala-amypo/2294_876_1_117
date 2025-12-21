package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")  // Allow Swagger / browser access
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    // Create a new user (POST)
    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    // Get all users (GET)
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID (GET)
    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
