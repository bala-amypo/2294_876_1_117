package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;

    @Autowired
    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody UserAccount request) {
        UserAccount createdUser = userAccountService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAccount> login(@RequestBody LoginRequest request) {
        UserAccount user = userAccountService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(user);
    }
}
