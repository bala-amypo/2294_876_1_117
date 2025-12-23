package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userService;

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userService.saveUser(user);   // ✅ FIXED
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAll();
    }
}
