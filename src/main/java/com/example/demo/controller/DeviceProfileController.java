package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
        return deviceService.registerDevice(device);
    }

    @GetMapping("/{deviceId}")
    public DeviceProfile getDevice(@PathVariable String deviceId) {
        return deviceService.getDeviceByDeviceId(deviceId);
    }

    @PutMapping("/{deviceId}/trust")
    public DeviceProfile updateTrust(
            @PathVariable String deviceId,
            @RequestParam boolean trusted) {
        return deviceService.updateDeviceTrust(deviceId, trusted);
    }
}
