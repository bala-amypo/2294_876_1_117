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
    public UserAccount save(@RequestBody UserAccount user) {
        return userAccountService.save(user);
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return userAccountService.findById(id).orElse(null);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return userAccountService.findAll();
    }
}
