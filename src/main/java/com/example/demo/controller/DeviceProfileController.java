package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile trust(@PathVariable Long id,
                               @RequestParam boolean trust) {
        return service.updateTrustStatus(id, trust);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> byUser(@PathVariable Long userId) {
        return service.getDevicesByUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        DeviceProfile profile = service.findByDeviceId(deviceId);
        return ResponseEntity.ok(profile);
    }
}

