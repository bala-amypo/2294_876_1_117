package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
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
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userAccountService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userAccountService.getUserById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return userAccountService.updateStatus(id, status);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }
}
