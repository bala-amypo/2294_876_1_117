package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/")
    public UserAccount createUser(@RequestBody UserAccount user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id,
                             @RequestParam String status) {
        service.updateStatus(id, status);
    }

    @GetMapping("/")
    public List<UserAccount> getAllUsers() {
        return service.getAll();
    }
}
