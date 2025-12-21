package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUser(@PathVariable Long id) {
        UserAccount user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(userService.updateStatus(id, status));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
