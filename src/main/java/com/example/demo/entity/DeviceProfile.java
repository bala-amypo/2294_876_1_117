package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity

public class DeviceProfile {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true)
    private Long userId;

    @Column(unique=true)
    private String deviceId;

    private String deviceType;

    private String osVersion;

    private LocalDateTime lastSeen;

    private Boolean isTrusted = false;

public void setTrusted(boolean trusted) {
    this.isTrusted = trusted;
}


    public DeviceProfile() {
    }

    public DeviceProfile(Long userId, String deviceId,
                         String deviceType, String osVersion) {
        this.id=id;
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
    }

    // @PrePersist
    // @PreUpdate
    // protected void updateLastSeen() {
    //     this.lastSeen = LocalDateTime.now();
    // }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public Boolean getIsTrusted() {
        return isTrusted;
    }

    public void setIsTrusted(Boolean trusted) {
        isTrusted = trusted;
    }
}
