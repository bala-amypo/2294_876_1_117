package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> registerUser(@RequestBody UserAccount user) {
        UserAccount savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAccount> loginUser(@RequestBody UserAccount loginRequest) {
        UserAccount user = userService.findByUsername(loginRequest.getUsername());
        // Password check will be handled by SecurityConfig
        return ResponseEntity.ok(user);
    }
}
