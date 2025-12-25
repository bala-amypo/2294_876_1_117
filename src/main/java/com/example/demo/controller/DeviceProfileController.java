package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    // REQUIRED for Mockito test
    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    // testDeviceControllerLookup
    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        Optional<DeviceProfile> device = service.findByDeviceId(deviceId);
        return device.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // Swagger support
    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }
}
