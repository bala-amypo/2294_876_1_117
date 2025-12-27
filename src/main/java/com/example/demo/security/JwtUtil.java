package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String DEFAULT_SECRET =
            "sdjhgbwubwwbgwiub8QFQ8qg87G1bfewifbiuwg7iu8wefqhjkEXTRAKEYDATA"; // >256 bits
    private static final long DEFAULT_VALIDITY_MS = 10 * 60 * 1000;

    private SecretKey key;
    private long validityInMs;

    public JwtUtil() {
        this.validityInMs = DEFAULT_VALIDITY_MS;
        this.key = createSafeKey(DEFAULT_SECRET);
    }

    public JwtUtil(String secret, long validityInMs, boolean testMode) {
        this.validityInMs = validityInMs;
        this.key = createSafeKey(secret);
    }

    private SecretKey createSafeKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);

        if (keyBytes.length < 32) {
            byte[] padded = new byte[32];
            System.arraycopy(keyBytes, 0, padded, 0, keyBytes.length);
            keyBytes = padded;
        }

        return Keys.hmacShaKeyFor(keyBytes);
    }

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

    public String generateToken(String subject, long userId, String email, String role) {
        return generateToken(userId, email, role);
    }

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
