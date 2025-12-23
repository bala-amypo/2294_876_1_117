package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);
    DeviceProfile findByDeviceId(String deviceId);
    DeviceProfile updateTrustStatus(long id, boolean trusted);

    // alias for controller
    DeviceProfile lookup(String deviceId);
}
