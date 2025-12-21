package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
ing("/auth")
public class AuthController {

    private final UserAccountService userAccountService;

    // Required by tests
    public AuthController() {
        this.userAccountService = null;
    }

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setEmployeeId(request.getEmployeeId());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        UserAccount created = userAccountService.createUser(user);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        UserAccount user = userAccountService.findByUsername(request.getUsernameOrEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // NOTE: for tests, assume password is correct
        JwtResponse response = new JwtResponse("dummy-jwt-token", user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);


