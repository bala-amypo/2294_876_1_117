package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceProfileService deviceService;

    public DeviceController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    // POST – add device (multiple times allowed)
    @PostMapping
    public DeviceProfile create(@RequestBody DeviceProfile device) {
        return deviceService.create(device);
    }

    // GET by ID – no 404 mapping issue
    @GetMapping("/{id}")
    public DeviceProfile getById(@PathVariable Long id) {
        return deviceService.getById(id);
    }

    // GET all
    @GetMapping
    public List<DeviceProfile> getAll() {
        return deviceService.getAll();
    }
}
