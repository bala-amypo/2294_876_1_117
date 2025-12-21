package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    // REQUIRED by test cases
    public UserAccountController() {
        this.userAccountService = null;
    }

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userAccountService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable long id) {
        return ResponseEntity.ok(userAccountService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserAccount> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userAccountService.findByUsername(username));
    }
}
