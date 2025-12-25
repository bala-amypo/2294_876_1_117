package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    // REQUIRED for Mockito
    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repo.save(device);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, Boolean trusted) {

    DeviceProfile device = repo.findById(id).orElse(null);

        if (device == null) {
            return null;
        }

        device.setIsTrusted(trusted);
        return repo.save(device);
    }
}
