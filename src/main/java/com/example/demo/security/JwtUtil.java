package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // ===== DEFAULT VALUES (USED BY SPRING) =====
    private static final String DEFAULT_SECRET =
            "sdjhgbwubwwbgwiub8QFQ8qg87G1bfewifbiuwg7iu8wefqhjk"; // >=256-bit
    private static final long DEFAULT_VALIDITY_MS = 10 * 60 * 1000; // 10 minutes

    // ===== CONFIGURABLE FIELDS (USED BY TESTS) =====
    private String secret;
    private long validityInMs;
    private boolean testMode;

    private SecretKey key;

    // ===== NO-ARG CONSTRUCTOR (SPRING USES THIS) =====
    public JwtUtil() {
        this.secret = DEFAULT_SECRET;
        this.validityInMs = DEFAULT_VALIDITY_MS;
        this.testMode = false;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ===== TEST CONSTRUCTOR (TEST SUITE EXPECTS THIS) =====
    public JwtUtil(String secret, long validityInMs, boolean testMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.testMode = testMode;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ===== ORIGINAL METHOD (USED BY YOUR APP) =====
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===== OVERLOADED METHOD (TEST SUITE EXPECTS THIS) =====
    public String generateToken(String subject, long userId, String email, String role) {
        return generateToken(Long.valueOf(userId), email, role);
    }

    // ===== TOKEN VALIDATION =====
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // ===== CLAIM READERS =====
    public String getEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Long getUserId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userId", Long.class);
    }

    public String getRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }
}
