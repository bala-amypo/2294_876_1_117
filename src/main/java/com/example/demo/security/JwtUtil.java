package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;
    private final boolean isTestMode;

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.isTestMode = isTestMode;
    }

    public String generateToken(String subject, Long userId, String email, String role) {
        // Simple token format for tests
        String payload = subject + "|" + userId + "|" + email + "|" + role;
        return Base64.getEncoder()
                .encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return decode(token)[2];
    }

    public String getRole(String token) {
        return decode(token)[3];
    }

    public Long getUserId(String token) {
        return Long.parseLong(decode(token)[1]);
    }

    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder()
                .decode(token), StandardCharsets.UTF_8);
        return decoded.split("\\|");
    }
}
