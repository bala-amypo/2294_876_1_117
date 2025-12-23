package com.example.demo.security;

public class JwtUtil {

    private String secret;
    private long expiration;
    private boolean enabled;

    public JwtUtil() {
    }

    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.secret = secret;
        this.expiration = expiration;
        this.enabled = enabled;
    }

    public String generateToken(String email, Long userId, String role, String username) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmail(String token) {
        return "test@email.com";
    }

    public String getRole(String token) {
        return "USER";
    }

    public Long getUserId(String token) {
        return 1L;
    }
}
