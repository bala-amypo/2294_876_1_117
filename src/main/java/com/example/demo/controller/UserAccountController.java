package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        UserAccount created = userAccountService.createUser(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUser(@PathVariable Long id) {
        UserAccount user = userAccountService.getUserById(id); // already returns UserAccount, not Optional
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @RequestParam String status) {
        UserAccount updated = userAccountService.updateUserStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = userAccountService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Example fix if you want to find by username (Optional)
    @GetMapping("/by-username/{username}")
    public ResponseEntity<UserAccount> getByUsername(@PathVariable String username) {
        UserAccount user = userAccountService.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok(user);
    }
}
