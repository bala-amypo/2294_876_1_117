package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private UserAccountService service;

    // REQUIRED BY TEST
    public UserAccountController() {}

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserAccount> create(UserAccount user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> update(@PathVariable long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateUserStatus(id, status));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> all() {
        return ResponseEntity.ok(service.getAllUsers());
    }
}
