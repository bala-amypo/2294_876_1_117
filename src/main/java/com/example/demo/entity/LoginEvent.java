package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {

    @Id
    private Long id;

    private Long userId;
    private String ipAddress;
    private String loginStatus;  // Needed for RuleEvaluationUtil
    private LocalDateTime timestamp;

    public LoginEvent() {}

    public LoginEvent(Long userId, String ipAddress, String loginStatus, LocalDateTime timestamp) {
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.loginStatus = loginStatus;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getLoginStatus() { return loginStatus; }
    public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
