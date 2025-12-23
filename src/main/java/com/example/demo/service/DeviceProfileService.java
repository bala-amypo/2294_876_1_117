package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile lookup(String deviceId);

    DeviceProfile save(DeviceProfile deviceProfile);
}
