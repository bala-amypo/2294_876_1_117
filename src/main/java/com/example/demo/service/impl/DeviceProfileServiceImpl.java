package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<DeviceProfile> lookup(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile save(DeviceProfile deviceProfile) {
        return repository.save(deviceProfile);
    }
}
