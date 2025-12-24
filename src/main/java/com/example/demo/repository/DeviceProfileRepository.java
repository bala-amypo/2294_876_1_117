package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface DeviceProfileRepository {
    DeviceProfile save(DeviceProfile d);
    Optional<DeviceProfile> findById(Long id);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
