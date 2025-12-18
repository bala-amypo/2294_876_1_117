package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile register(DeviceProfile device);

    DeviceProfile updateTrust(Long id, boolean trusted);

    List<DeviceProfile> byUser(Long userId);
}
