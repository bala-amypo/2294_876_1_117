package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Generate a dummy token
    public String generateToken(String username) {
        return "token_" + username;
    }

    // Extract username from the dummy token
    public String extractUsername(String token) {
        if (token == null) return null;
        return token.replace("token_", "");
    }

    // Validate token
    public boolean validateToken(String token) {
        return token != null && token.startsWith("token_");
    }
}
