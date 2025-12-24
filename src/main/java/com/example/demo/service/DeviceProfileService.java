package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile deviceProfile);

    DeviceProfile findByDeviceId(String deviceId);  // <- MUST match Impl

    DeviceProfile updateTrustStatus(Long id, boolean isTrusted);
}
