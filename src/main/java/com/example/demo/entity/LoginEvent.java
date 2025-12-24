package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {

    @Id
    private Long id;

    private Long userId;

    private String ipAddress;

    private LocalDateTime loginTime;

    // 🔥 THIS FIELD WAS MISSING
    private String status;

    public LoginEvent() {
    }

    public LoginEvent(Long userId, String ipAddress, LocalDateTime loginTime, String status) {
        this.id=id;
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.loginTime = loginTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
