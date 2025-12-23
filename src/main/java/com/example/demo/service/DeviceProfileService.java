package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

import java.util.Optional;

public interface DeviceProfileService {
    Optional<DeviceProfile> getById(Long id);
}
