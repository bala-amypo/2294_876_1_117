package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    @Autowired
    private DeviceProfileRepository repository;

    @Override
    public DeviceProfile register(DeviceProfile device) {
        return repository.save(device);
    }

    @Override
    public DeviceProfile updateTrust(Long id, boolean trusted) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device != null) {
            device.setTrusted(trusted);
            return repository.save(device);
        }
        return null;
    }

    @Override
    public List<DeviceProfile> byUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
