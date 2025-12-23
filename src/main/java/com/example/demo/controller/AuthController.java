package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    // Constructor injection
    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        // Find user by email
        UserAccount user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Dummy password check
        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // Generate token
        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam String token) {
        boolean valid = jwtUtil.validateToken(token);
        return valid ? ResponseEntity.ok("Token is valid")
                     : ResponseEntity.status(401).body("Token is invalid");
    }
}
