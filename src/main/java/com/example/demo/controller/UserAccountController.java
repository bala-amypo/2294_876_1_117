package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public UserAccount get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserAccount> all() {
        return userService.getAll();
    }
}
