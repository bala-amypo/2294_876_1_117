package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeviceProfile {

    @Id
    @Column(unique = true)
    private Long id;

    private Long userId;

    @Column(unique = true, nullable = false)
    private String deviceId;

    private String deviceType;

    private String osVersion;

    private LocalDateTime lastSeen;

    private Boolean isTrusted = false;

    @PrePersist
    public void prePersist() {
        if (lastSeen == null) lastSeen = LocalDateTime.now();
    }

    public DeviceProfile() {}

    public DeviceProfile(Long id, Long userId, String deviceId, String deviceType, String osVersion) {
        this.id = id;
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
        this.lastSeen = LocalDateTime.now();
        this.isTrusted = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }

    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }

    public Boolean getIsTrusted() { return isTrusted; }
    public void setIsTrusted(Boolean isTrusted) { this.isTrusted = isTrusted; }
}
