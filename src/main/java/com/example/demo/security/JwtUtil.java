package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public JwtUtil() {
}

public JwtUtil(String secret, long expiration, boolean enabled) {
    this.secret = secret;
    this.expiration = expiration;
    this.enabled = enabled;
}
