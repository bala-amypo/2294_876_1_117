package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        DeviceProfile saved = deviceService.registerDevice(device);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceProfile> getDevice(@PathVariable String deviceId) {
        Optional<DeviceProfile> device = deviceService.findByDeviceId(deviceId);
        return device.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestParam boolean trusted) {
        DeviceProfile updated = deviceService.updateTrustStatus(id, trusted);
        return ResponseEntity.ok(updated);
    }
}
