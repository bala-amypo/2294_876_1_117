package com.example.demo.security;

public class JwtUtil {

    // No-arg constructor
    public JwtUtil() {}

    // Dummy generateToken method
    public String generateToken(String username) {
        return "dummy-token-for-" + username;
    }

    public String getEmail(String token) {
        return "dummy@example.com";
    }

    public String getRole(String token) {
        return "USER";
    }

    public Long getUserId(String token) {
        return 1L;
    }
}
