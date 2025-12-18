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
    private UserAccountService service;

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return service.create(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAll();
    }
}
