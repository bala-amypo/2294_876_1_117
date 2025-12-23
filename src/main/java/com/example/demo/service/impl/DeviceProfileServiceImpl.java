package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repository.save(device);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean isTrusted) {
        DeviceProfile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        existing.setIsTrusted(isTrusted);
        return repository.save(existing);
    }

    @Override
    public List<DeviceProfile> getAllDevices() {
        return repository.findAll();
    }
}
