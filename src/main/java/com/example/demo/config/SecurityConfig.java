package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Bean for password encoding
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Basic security filter chain (customize as needed)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for simplicity, adjust if needed
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // allow auth endpoints
                .anyRequest().authenticated()           // all other endpoints require auth
            )
            .httpBasic(); // use HTTP basic auth, can switch to JWT filter if needed

        return http.build();
    }
}
