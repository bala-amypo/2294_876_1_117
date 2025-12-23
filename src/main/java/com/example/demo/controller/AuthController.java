package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email) {

        UserAccount user = userService.findByEmail(email);

        // 🔴 THIS IS THE IMPORTANT LINE
        return jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                user.getRole(),
                user.getStatus()
        );
    }
}
