package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    @Column(unique = true)
    private String username;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;   // ✅ ENUM (DO NOT DELETE)

    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (status == null) status = "ACTIVE";
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (role == null) role = Role.USER; // ✅ default role
    }

    // ===== GETTERS / SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ✅ ENUM SETTER
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // ✅ STRING ADAPTER (THIS FIXES TESTS)
    public void setRole(String role) {
        this.role = Role.valueOf(role.toUpperCase());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
