package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "user_accounts",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "employeeId"),
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class UserAccount {

    // =========================
    // Primary Key
    // =========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // User Identity Fields
    // =========================
    @Column(nullable = false, unique = true)
    private String employeeId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    // =========================
    // Authentication Fields
    // =========================
    @Column(nullable = false)
    private String password;

    // ADMIN / USER / AUDITOR
    @Column(nullable = false)
    private String role;

    // ACTIVE / SUSPENDED
    @Column(nullable = false)
    private String status = "ACTIVE";

    // =========================
    // Audit Fields
    // =========================
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // =========================
    // Constructors
    // =========================
    public UserAccount() {
        // Default constructor required by JPA
    }

    public UserAccount(String employeeId, String username, String email,
                       String password, String role) {
        this.employeeId = employeeId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = "ACTIVE";
    }

    // =========================
    // JPA Lifecycle Callback
    // =========================
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "ACTIVE";
        }
    }

    // =========================
    // Getters and Setters
    // =========================
    public Long getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setId(Long id) {
        this.id = id;
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
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
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
