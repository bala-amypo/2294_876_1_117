package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping("/")
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.register(device);
    }

    @PutMapping("/{id}/trust")
    public void updateTrust(@PathVariable Long id,
                            @RequestParam boolean trust) {
        service.updateTrust(id, trust);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getByUser(@PathVariable Long userId) {
        return service.byUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile findByDevice(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId);
    }
}
