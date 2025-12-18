package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    @Autowired
    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repository.save(device);
    }

    @Override
    public void updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trust);
            repository.save(device);
        }
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId).orElse(null);
    }
}
