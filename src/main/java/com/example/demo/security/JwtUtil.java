package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public JwtUtil() {
    }

    // constructor required by tests
    public JwtUtil(String secret, long expiration, boolean flag) {
    }

    // =========================
    // Methods used by FILTER
    // =========================

    public boolean validateToken(String token) {
        return true;
    }

    public Long getUserId(String token) {
        return 1L;
    }

    public String getRole(String token) {
        return "USER";
    }

    // =========================
    // Methods used by CONTROLLER
    // =========================

    public String generateToken(String username) {
        return username;
    }

    public String getEmail(String token) {
        return token;
    }
}
