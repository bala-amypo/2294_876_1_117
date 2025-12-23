package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime eventTime;

    private Boolean suspicious;  // <-- ADD THIS

    public LoginEvent() {
    }

    public LoginEvent(Long userId, LocalDateTime eventTime, Boolean suspicious) {
        this.userId = userId;
        this.eventTime = eventTime;
        this.suspicious = suspicious;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    public Boolean isSuspicious() { return suspicious; }  // <-- getter
    public void setSuspicious(Boolean suspicious) { this.suspicious = suspicious; }
}
