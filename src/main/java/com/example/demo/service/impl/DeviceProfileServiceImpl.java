package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile updateTrustStatus(long id, boolean isTrusted) {
        Optional<DeviceProfile> optional = repo.findById(id);
        if(optional.isPresent()) {
            DeviceProfile dp = optional.get();
            dp.setIsTrusted(isTrusted);
            return repo.save(dp); // return the saved entity
        }
        return null;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId).orElse(null);
    }
}
