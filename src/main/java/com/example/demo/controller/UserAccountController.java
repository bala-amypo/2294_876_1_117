package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    // 🔥 REQUIRED by Test Cases
    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        UserAccount savedUser = userAccountService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // 🔥 REQUIRED by Test Cases
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        UserAccount user = userAccountService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
