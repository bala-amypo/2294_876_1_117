package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceProfileRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceProfileRepo) {
        this.deviceProfileRepo = deviceProfileRepo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return deviceProfileRepo.save(device);
    }

    @Override
    public DeviceProfile lookup(String deviceId) {
        return deviceProfileRepo.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found: " + deviceId));
    }
}
