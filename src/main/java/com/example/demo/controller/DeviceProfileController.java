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

    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(deviceService.registerDevice(device));
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrustStatus(@PathVariable Long id, @RequestParam boolean trust) {
        return ResponseEntity.ok(deviceService.updateTrustStatus(id, trust));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDevicesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(deviceService.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> getDeviceById(@PathVariable String deviceId) {
        return ResponseEntity.of(deviceService.findByDeviceId(deviceId));
    }
}
