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
    public DeviceProfile lookup(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }

    @Override
    public void updateTrustStatus(long id, boolean trusted) {
        Optional<DeviceProfile> dp = repository.findById(id);
        dp.ifPresent(d -> {
            d.setIsTrusted(trusted);
            repository.save(d);
        });
    }
}
