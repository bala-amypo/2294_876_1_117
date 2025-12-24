package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;

    @Autowired
    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserAccount user) {
        UserAccount createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserAccount loginRequest) {
        Optional<UserAccount> optionalUser = userService.findByUsername(loginRequest.getUsername());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        UserAccount user = optionalUser.get();
        // TODO: Add password verification logic here
        return ResponseEntity.ok(user);
    }
}
