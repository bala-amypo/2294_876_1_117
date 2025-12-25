package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceProfileService;

    public DeviceProfileController(DeviceProfileService deviceProfileService) {
        this.deviceProfileService = deviceProfileService;
    }

    @PostMapping
    public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
        return deviceProfileService.registerDevice(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile trustDevice(@PathVariable Long id) {
        return deviceProfileService.updateTrust(id, true);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getByUser(@PathVariable Long userId) {
        return deviceProfileService.getDevicesByUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile lookup(@PathVariable String deviceId) {
        return deviceProfileService.getByDeviceId(deviceId);
    }
}
