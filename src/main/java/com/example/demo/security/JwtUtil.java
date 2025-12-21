package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    // Dummy method for token creation
    public String generateToken(String username) {
        return "dummy-token-for-" + username;
    }

    // Dummy method for token validation
    public boolean validateToken(String token) {
        return true;
    }

    // Dummy method for extracting username
    public String getUsernameFromToken(String token) {
        return "dummyUser";
    }
}
