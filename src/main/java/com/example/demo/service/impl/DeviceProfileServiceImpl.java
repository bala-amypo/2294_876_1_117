package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    @Autowired
    private DeviceProfileRepository repo;

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, Boolean isTrusted) {
        DeviceProfile device = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setIsTrusted(isTrusted);
        return repo.save(device);
    }
}
