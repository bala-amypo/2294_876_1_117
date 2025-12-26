package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    // ✅ POST /api/devices
    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return deviceService.registerDevice(device);
    }

    // ✅ PUT /api/devices/{id}/trust
    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(
            @PathVariable Long id,
            @RequestParam boolean trust) {
        return deviceService.updateTrustStatus(id, trust);
    }

    // ✅ GET /api/devices/user/{userId}
    @GetMapping("/user/{userId}")
    public List<DeviceProfile> byUser(@PathVariable Long userId) {
        return deviceService.getDevicesByUser(userId);
    }

    // ✅ GET /api/devices/lookup/{deviceId}
    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        return ResponseEntity.of(deviceService.findByDeviceId(deviceId));
    }
}
