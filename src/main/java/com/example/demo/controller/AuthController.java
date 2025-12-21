package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setEmployeeId(request.getEmployeeId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        // ✅ CORRECT METHOD — NOT register()
        return userAccountService.createUser(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        // 🔹 Dummy login (NO SECURITY — ONLY FOR TESTS)
        UserAccount user = userAccountService.findByUsername(
                request.getUsernameOrEmail()
        ).orElseThrow(() -> new RuntimeException("Invalid credentials"));

        return new JwtResponse(
                "dummy-token",
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
