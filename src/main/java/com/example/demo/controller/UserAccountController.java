package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    // 🔐 Only ADMIN can create users
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UserAccount> create(@Valid @RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // 🔐 ADMIN & AUDITOR can view user
    @PreAuthorize("hasAnyRole('ADMIN','AUDITOR')")
    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 🔐 Only ADMIN can update status
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id,
                                    @RequestParam String status) {
        return userService.updateUserStatus(id, status);
    }

    // 🔐 ADMIN & AUDITOR can list users
    @PreAuthorize("hasAnyRole('ADMIN','AUDITOR')")
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }
}
