package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    @Autowired
    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    // Register a new device
    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        DeviceProfile savedDevice = deviceService.registerDevice(device);
        return ResponseEntity.ok(savedDevice);
    }

    // Get device by deviceId
    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceProfile> getDeviceById(@PathVariable String deviceId) {
        DeviceProfile device = deviceService.findByDeviceId(deviceId);
        if (device != null) {
            return ResponseEntity.ok(device);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update trust status of a device
    @PutMapping("/{deviceId}/trust")
    public ResponseEntity<DeviceProfile> updateTrustStatus(
            @PathVariable Long deviceId,
            @RequestParam boolean trusted
    ) {
        DeviceProfile updatedDevice = deviceService.updateTrustStatus(deviceId, trusted);
        if (updatedDevice != null) {
            return ResponseEntity.ok(updatedDevice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
