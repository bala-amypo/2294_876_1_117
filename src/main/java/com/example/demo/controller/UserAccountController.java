package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserAccountService userService;

    public UserController(UserAccountService userService) {
        this.userService = userService;
    }

    // ✅ ADMIN only
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ ADMIN + AUDITOR
    @PreAuthorize("hasAnyRole('ADMIN','AUDITOR')")
    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ USER (self), ADMIN
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/{id}/status")
    public UserAccount updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return userService.updateStatus(id, status);
    }
}
