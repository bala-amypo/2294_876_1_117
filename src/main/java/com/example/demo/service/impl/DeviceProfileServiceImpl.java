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
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repo.save(device);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId).orElse(null);
    }

    @Override
    public DeviceProfile updateTrustStatus(long id, boolean trusted) {
        DeviceProfile d = repo.findById(id).orElse(null);
        if (d != null) {
            d.setIsTrusted(trusted);
            repo.save(d);
        }
        return d;
    }
}
