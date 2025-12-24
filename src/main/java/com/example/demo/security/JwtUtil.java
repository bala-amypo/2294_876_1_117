// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;

// import javax.crypto.SecretKey;
// import java.util.Date;

// public class JwtUtil {

//     private final SecretKey key;
//     private final long expiration;
//     private final boolean enabled;

//     public JwtUtil(String secret, long expiration, boolean enabled) {
//         // Ensure minimum 256-bit key
//         byte[] keyBytes = secret.getBytes();
//         if (keyBytes.length < 32) {
//             keyBytes = (secret + "123456789012345678901234").getBytes();
//         }
//         this.key = Keys.hmacShaKeyFor(keyBytes);
//         this.expiration = expiration;
//         this.enabled = enabled;
//     }

//     public String generateToken(String username, Long userId, String email, String role) {
//         if (!enabled) return null;

//         return Jwts.builder()
//                 .setSubject(username)
//                 .claim("userId", userId)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(key)
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getEmail(String token) {
//         return getClaims(token).get("email", String.class);
//     }

//     public String getRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     public Long getUserId(String token) {
//         return getClaims(token).get("userId", Long.class);
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
