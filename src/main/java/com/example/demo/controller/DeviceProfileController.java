package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
        return deviceService.registerDevice(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(@PathVariable Long id,
                                     @RequestParam boolean trusted) {
        return deviceService.updateTrustStatus(id, trusted);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getByUser(@PathVariable Long userId) {
        return deviceService.getDevicesByUser(userId);
    }

@GetMapping("/lookup/{deviceId}")
public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
    return deviceService.findByDeviceId(deviceId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

}