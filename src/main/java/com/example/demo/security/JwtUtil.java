package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private String secret;
    private long validityInMillis;
    private boolean someFlag;

    // Constructor matching the test
    public JwtUtil(String secret, long validityInMillis, boolean someFlag) {
        this.secret = secret;
        this.validityInMillis = validityInMillis;
        this.someFlag = someFlag;
    }

    // Default no-arg constructor
    public JwtUtil() {
    }

    // Method expected by tests: generateToken with one parameter
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Overloaded method matching test calls with 4 parameters
    public String generateToken(String username, long userId, String role, String extra) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("role", role)
                .claim("extra", extra)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Methods expected by tests
    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public String getRole(String token) {
        return (String) getClaims(token).get("role");
    }

    public long getUserId(String token) {
        Object id = getClaims(token).get("userId");
        if (id instanceof Integer) return ((Integer) id).longValue();
        if (id instanceof Long) return (Long) id;
        return 0L;
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
