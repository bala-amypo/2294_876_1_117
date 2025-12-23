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

    // ✅ matches interface: lookup(String)
    // ✅ handles Optional correctly
    @Override
    public DeviceProfile lookup(String deviceId) {
        return repo.findByDeviceId(deviceId)
                .orElse(null);
    }
}
