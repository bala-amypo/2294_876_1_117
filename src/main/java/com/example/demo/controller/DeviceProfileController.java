package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    @Autowired
    private DeviceProfileService service;

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.register(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(@PathVariable Long id, @RequestParam boolean trusted) {
        return service.updateTrust(id, trusted);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> byUser(@PathVariable Long userId) {
        return service.byUser(userId);
    }
}
