package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

import java.util.Optional;

public interface DeviceProfileService {

    DeviceProfile save(DeviceProfile device);

    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
