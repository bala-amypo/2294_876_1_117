package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService, JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // 🔥 REQUIRED BY TEST CASES
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccount request) {

        UserAccount user =
                userAccountService.findByUsername(request.getUsername());

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(token);
    }
}
