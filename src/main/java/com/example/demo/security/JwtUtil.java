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
    private final boolean someFlag;

    public JwtUtil(String secret, long expirationMillis, boolean someFlag) {
        if (secret.length() < 32) {
            secret = (secret + "00000000000000000000000000000000").substring(0, 32);
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMillis = expirationMillis;
        this.someFlag = someFlag;
    }

    // Corrected: email goes into subject, role in "role" claim
    public String generateToken(String email, long userId, String role, String something) {
        Claims claims = Jwts.claims();
        claims.put("role", role);
        claims.put("userId", userId);
        claims.put("something", something);

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiry = new Date(nowMillis + expirationMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)  // <--- subject is email
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return extractAllClaims(token).getSubject(); // <--- subject is email
    }

    public String getRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long getUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
