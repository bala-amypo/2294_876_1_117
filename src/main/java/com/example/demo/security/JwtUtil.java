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

    public String generateToken(String username) {
        return "dummy-token";
    }
}
