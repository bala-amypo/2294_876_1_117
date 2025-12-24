package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile getDeviceByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId)
                   .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public DeviceProfile updateDeviceTrust(String deviceId, boolean isTrusted) {
        DeviceProfile device = getDeviceByDeviceId(deviceId);
        device.setIsTrusted(isTrusted);
        return repo.save(device);
    }
}
