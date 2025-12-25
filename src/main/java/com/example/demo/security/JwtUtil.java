package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final long expirationMillis;
    private final boolean someFlag; // can be used if needed for test

    // Constructor expected by your test
    public JwtUtil(String secret, long expirationMillis, boolean someFlag) {
        if (secret.length() < 32) {
            // ensure secure key >= 256 bits (32 bytes)
            secret = secret + "00000000000000000000000000000000";
            secret = secret.substring(0, 32);
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMillis = expirationMillis;
        this.someFlag = someFlag;
    }

    // Generate token with email, userId, role, something
    public String generateToken(String email, long userId, String role, String something) {
        Claims claims = Jwts.claims();
        claims.put("email", email);
        claims.put("userId", userId);
        claims.put("role", role);
        claims.put("something", something);

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiry = new Date(nowMillis + expirationMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate token (just check signature & expiration)
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract email from token
    public String getEmail(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("email", String.class);
    }

    // Extract role from token
    public String getRole(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("role", String.class);
    }

    // Extract userId from token
    public Long getUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", Long.class);
    }

    // Internal helper
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
