package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final long expiration;
    private final boolean enabled;

    // ✅ REQUIRED BY TEST CASE
    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.key = Keys.hmacShaKeyFor(fixSecret(secret));
        this.expiration = expiration;
        this.enabled = enabled;
    }

    // ✅ DEFAULT CONSTRUCTOR (Spring)
    public JwtUtil() {
        this("default-secret-key-default-secret-key", 3600000, true);
    }

    // 🔥 THIS IS THE FIX
    private static byte[] fixSecret(String secret) {
        byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);

        if (bytes.length < 32) { // 256 bits
            byte[] padded = new byte[32];
            System.arraycopy(bytes, 0, padded, 0, bytes.length);
            Arrays.fill(padded, bytes.length, 32, (byte) '0');
            return padded;
        }
        return bytes;
    }

    public String generateToken(String username, Long userId, String email, String role) {
        if (!enabled) return null;

        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return getClaims(token).get("email", String.class);
    }

    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public Long getUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
