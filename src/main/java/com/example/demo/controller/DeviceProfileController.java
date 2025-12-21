package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    // POST /api/devices
    @PostMapping
    public DeviceProfile addDevice(@RequestBody DeviceProfile device) {
        return deviceService.addDevice(device);
    }

    // GET /api/devices/user/{userId}
    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
        return deviceService.getDevicesByUser(userId);
    }

    // GET /api/devices/{id}
    @GetMapping("/{id}")
    public DeviceProfile getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }
}
