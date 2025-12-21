package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceProfileRepository;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceProfileRepository) {
        this.deviceProfileRepository = deviceProfileRepository;
    }

    @Override
    public DeviceProfile addDevice(DeviceProfile device) {
        return deviceProfileRepository.save(device);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceProfileRepository.findByUserId(userId);
    }
}
