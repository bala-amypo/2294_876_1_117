package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // POST /api/users
    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        UserAccount saved = service.createUser(user);
        return ResponseEntity.ok(saved);
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        UserAccount user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // PUT /api/users/{id}/status
    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @RequestParam String status) {
        UserAccount updated = service.updateUserStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    // GET /api/users
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
}
