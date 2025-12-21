package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserAccountService userAccountService, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setEmployeeId(request.getEmployeeId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }

        UserAccount created = userAccountService.createUser(user);
        return ResponseEntity.ok(created);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        // Find user by username or email
        UserAccount user = userAccountService.findByUsername(request.getUsernameOrEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Check password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getId(), user.getEmail(), user.getRole());
        JwtResponse response = new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }
}
