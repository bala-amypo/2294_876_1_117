package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {

    @Id
    @Column(unique = true)
    private Long id;

    private Long userId;

    @Column(nullable = false)
    private String ipAddress;

    private String location;

    @Column(nullable = false)
    private String deviceId;

    private LocalDateTime timestamp;

    private String loginStatus; // SUCCESS / FAILED

    @PrePersist
    public void prePersist() {
        if (timestamp == null) timestamp = LocalDateTime.now();
    }

    public LoginEvent() {}

    public LoginEvent(Long id, Long userId, String ipAddress, String location, String deviceId, String loginStatus) {
        this.id = id;
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.location = location;
        this.deviceId = deviceId;
        this.loginStatus = loginStatus;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getLoginStatus() { return loginStatus; }
    public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }
}
