package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile deviceProfile) {
        return deviceRepo.save(deviceProfile);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public DeviceProfile updateTrustStatus(long deviceId, boolean trusted) {
        DeviceProfile device = deviceRepo.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setIsTrusted(trusted);
        return deviceRepo.save(device);
    }
}
