package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    public DeviceProfile registerDevice(DeviceProfile d) {
        return repo.save(d);
    }

    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }

    public DeviceProfile updateTrustStatus(Long id, Boolean trusted) {
        DeviceProfile d = repo.findById(id).orElse(null);
        d.setIsTrusted(trusted);
        return repo.save(d);
    }
}
