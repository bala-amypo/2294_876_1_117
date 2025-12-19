package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        userService.updateStatus(id, status);
        return "Status updated successfully";
    }
}
