package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // must be at least 256 bits
    private final Key key = Keys.hmacShaKeyFor(
            "my-secret-key-my-secret-key-my-secret-key".getBytes()
    );

    private static final long EXPIRATION_MS = 1000 * 60 * 60; // 1 hour

    // ===============================
    // TOKEN GENERATION
    // ===============================
    public String generateToken(String username, Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(username)              // sub → username
                .claim("userId", userId)           // custom claim
                .claim("email", email)             // custom claim
                .claim("role", role)               // custom claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===============================
    // TOKEN VALIDATION
    // ===============================
    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ===============================
    // EXTRACTORS (THIS FIXES YOUR FAILURES)
    // ===============================
    public String getEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }

    public String getRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long getUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    public String getUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ===============================
    // INTERNAL
    // ===============================
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
