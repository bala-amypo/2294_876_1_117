package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    // Use a fixed 32-byte secret key (256 bits) for tests & Swagger
    private static final String SECRET = "01234567890123456789012345678901"; // 32 chars = 256 bits

    private final Key key;

    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // Generate JWT token
    public String generateToken(Map<String, Object> claims, String subject, long expirationMillis) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract subject (e.g., email or username)
    public String extractSubject(String token) {
        return getClaims(token).getSubject();
    }

    // Extract claims
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validate token
    public boolean validateToken(String token, String expectedSubject) {
        try {
            final String subject = extractSubject(token);
            return subject.equals(expectedSubject) && !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // Check expiration
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // Get the signing key (for tests or other usage)
    public Key getKey() {
        return key;
    }
}
