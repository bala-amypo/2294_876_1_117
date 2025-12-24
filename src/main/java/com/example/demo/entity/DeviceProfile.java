package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeviceProfile {

    @Id
    private Long id;
    private Long userId;
    private String deviceId;
    private String deviceType;
    private String osVersion;
    private Boolean isTrusted = false;
    private LocalDateTime lastSeen;

    // ✅ Setter/getter for lastSeen
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
    public LocalDateTime getLastSeen() { return lastSeen; }

    // existing getters/setters
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
    public Boolean getIsTrusted() { return isTrusted; }
    public void setIsTrusted(Boolean isTrusted) { this.isTrusted = isTrusted; }
}
