package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    @Autowired
    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserAccount user) {
        UserAccount createdUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserAccount> optionalUser = service.getUserById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        return ResponseEntity.ok(optionalUser.get());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateUserStatus(@PathVariable Long id, @RequestParam String status) {
        boolean updated = service.updateUserStatus(id, status);
        if (!updated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok("Status updated successfully");
    }
}
