package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        return ResponseEntity.ok(service.findByDeviceId(deviceId).orElse(null));
    }
}
