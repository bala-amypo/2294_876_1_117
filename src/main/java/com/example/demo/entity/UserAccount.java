package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
private String employeeId;
private String email;
private String password;
private String role;
private LocalDateTime createdAt;

// Getters and Setters
public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
public void setEmail(String email) { this.email = email; }
public void setRole(String role) { this.role = role; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

public String getEmail() { return email; }
public String getRole() { return role; }

    // ✅ Needed for test cases
    public Object getBody() { return this; }
}
