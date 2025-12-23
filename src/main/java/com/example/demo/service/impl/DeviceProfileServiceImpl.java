package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId).orElse(null);
    }

    @Override
    public DeviceProfile updateTrustStatus(long id, boolean trusted) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trusted);
            return repository.save(device);
        }
        return null;
    }
}
