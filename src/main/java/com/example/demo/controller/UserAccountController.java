package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserAccountController(UserAccountService userAccountService, BCryptPasswordEncoder passwordEncoder) {
        this.userAccountService = userAccountService;
        this.passwordEncoder = passwordEncoder;
    }

    // Create a user (required by test suite)
    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        // Hash password before saving
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        UserAccount createdUser = userAccountService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable Long id) {
        UserAccount user = userAccountService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Update user status (ACTIVE / SUSPENDED)
    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @RequestParam String status) {
        UserAccount updatedUser = userAccountService.updateUserStatus(id, status);
        return ResponseEntity.ok(updatedUser);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserAccount>> all() {
        List<UserAccount> users = userAccountService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
