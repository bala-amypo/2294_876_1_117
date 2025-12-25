package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    // 🔹 REQUIRED FOR TEST (DIRECT CALL)
    public UserAccount create(UserAccount user) {
        return userService.create(user);
    }

    // 🔹 REQUIRED FOR API (HTTP)
    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id,
                                    @RequestParam String status) {
        return userService.updateUserStatus(id, status);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }
}
