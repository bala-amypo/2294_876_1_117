package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile lookup(String deviceId) {
        return repo.findByDeviceId(deviceId).orElse(null);
    }

    // 🔥 THIS METHOD WAS MISSING (ERROR FIX)
    @Override
    public DeviceProfile updateTrustStatus(long id, boolean trusted) {
        DeviceProfile device = repo.findById(id).orElse(null);
        if (device == null) return null;

        device.setIsTrusted(trusted);
        return repo.save(device);
    }
}
