package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final BCryptPasswordEncoder passwordEncoder;

    // 🔹 Constructor used by Spring Boot
    public UserAccountController(UserAccountService userAccountService,
                                 BCryptPasswordEncoder passwordEncoder) {
        this.userAccountService = userAccountService;
        this.passwordEncoder = passwordEncoder;
    }

    // 🔹 Constructor used by TEST SUITE (VERY IMPORTANT)
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // 🔹 Test expects ResponseEntity + getBody()
    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        UserAccount saved = userAccountService.createUser(user);
        return ResponseEntity.ok(saved);
    }
}
