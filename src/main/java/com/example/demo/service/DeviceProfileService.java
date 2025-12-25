package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    List<DeviceProfile> getDevicesByUser(Long userId);

    DeviceProfile getByDeviceId(String deviceId);

    DeviceProfile updateTrust(Long id, Boolean trusted);
}
