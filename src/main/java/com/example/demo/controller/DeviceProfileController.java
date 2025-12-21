package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public DeviceProfile create(@RequestBody DeviceProfile device) {
        return deviceService.save(device);
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        return deviceService.findByDeviceId(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
