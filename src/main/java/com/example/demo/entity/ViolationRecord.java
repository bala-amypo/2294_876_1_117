package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ViolationRecord {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long policyRuleId;
    private Long eventId;
    private String violationType;
    private String details;
    private String severity;
    private LocalDateTime detectedAt;
    private Boolean resolved = false;

    public ViolationRecord() {
    }

    public ViolationRecord(Long userId, Long policyRuleId, Long eventId,
                           String violationType, String details, String severity) {
        this.id=id;
        this.userId = userId;
        this.policyRuleId = policyRuleId;
        this.eventId = eventId;
        this.violationType = violationType;
        this.details = details;
        this.severity = severity;
    }

    // @PrePersist
    // protected void onDetect() {
    //     this.detectedAt = LocalDateTime.now();
    //     if (this.resolved == null) {
    //         this.resolved = false;
    //     }
    // }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPolicyRuleId() {
        return policyRuleId;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSeverity() {
        return severity;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
}
