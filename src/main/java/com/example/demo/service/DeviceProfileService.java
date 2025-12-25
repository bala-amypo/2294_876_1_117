package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {
    List<DeviceProfile> getDevicesByUser(Long userId);
    DeviceProfile updateTrustStatus(Long id, Boolean isTrusted);
}
