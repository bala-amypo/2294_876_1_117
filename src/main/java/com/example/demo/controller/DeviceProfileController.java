package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    // POST /api/devices
    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    // PUT /api/devices/{id}/trust
    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestParam boolean trust) {
        return ResponseEntity.ok(service.updateTrustStatus(id, trust));
    }

    // GET /api/devices/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDevicesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getDevicesByUser(userId));
    }

    // GET /api/devices/lookup/{deviceId}
    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> findByDeviceId(@PathVariable String deviceId) {
        return ResponseEntity.ok(service.findByDeviceId(deviceId).orElse(null));
    }
    @GetMapping("/{deviceId}")
public DeviceProfile lookup(@PathVariable String deviceId) {
    return deviceService.lookup(deviceId);
}

}
