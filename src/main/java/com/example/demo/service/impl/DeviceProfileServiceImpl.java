package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceProfileRepository;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceProfileRepository) {
        this.deviceProfileRepository = deviceProfileRepository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile deviceProfile) {
        return deviceProfileRepository.save(deviceProfile);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return deviceProfileRepository.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean isTrusted) {
        DeviceProfile device = deviceProfileRepository.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(isTrusted);
            deviceProfileRepository.save(device);
        }
        return device;
    }
}
