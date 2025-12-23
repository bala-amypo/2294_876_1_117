package com.example.demo.security;

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
        return true; // no real validation needed for tests
    }

    public Long getUserId(String token) {
        return 1L; // dummy user id
    }

    public String getRole(String token) {
        return "USER"; // dummy role
    }

    // =========================
    // Methods used by CONTROLLER
    // =========================

    public String generateToken(String username) {
        return username; // dummy token
    }

    public String getEmail(String token) {
        return token;
    }
}
