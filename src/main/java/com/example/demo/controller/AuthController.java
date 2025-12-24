package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserAccountService userService;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService,
                          PasswordEncoder encoder,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest req) {
        UserAccount user = new UserAccount();
        user.setEmployeeId(req.getEmployeeId());
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest req) {
        UserAccount user = userService.findByUsername(req.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}
