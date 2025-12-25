package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    @Autowired
    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile getByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, Boolean isTrusted) {
        DeviceProfile device = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setIsTrusted(isTrusted);
        return repo.save(device);
    }

    @Override
    public List<DeviceProfile> getAllDevices() {
        return repo.findAll();
    }
}
