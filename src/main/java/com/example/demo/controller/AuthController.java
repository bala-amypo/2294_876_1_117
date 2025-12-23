package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserAccountService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userService.saveUser(user);   // ✅ CORRECT METHOD
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        UserAccount user = userService.findByUsername(request.getUsername());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new JwtResponse(
                token,
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
    }
}
