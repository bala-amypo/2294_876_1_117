package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userRepo;

    public AuthController(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        // ❌ REMOVED setUsername
        // ✅ USE email
        return userRepo.save(user);
    }

    @GetMapping("/user/{email}")
    public UserAccount getByEmail(@PathVariable String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
