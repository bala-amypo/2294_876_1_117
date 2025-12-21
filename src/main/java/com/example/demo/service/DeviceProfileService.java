package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

import java.util.List;

public interface DeviceProfileService {

    DeviceProfile addDevice(DeviceProfile device);

    List<DeviceProfile> getDevicesByUser(Long userId);
}
