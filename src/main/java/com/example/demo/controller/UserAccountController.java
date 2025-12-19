package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return user; // dummy return
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return new UserAccount();
    }

    @PutMapping("/{id}/status")
    public UserAccount updateUserStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return new UserAccount();
    }
}
