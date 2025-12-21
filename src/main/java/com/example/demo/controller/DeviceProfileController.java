package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public DeviceProfile getDevice(@PathVariable Long id) {
        return deviceService.getDevicesByUser(id).stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
        return deviceService.getDevicesByUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public Optional<DeviceProfile> getByDeviceId(@PathVariable String deviceId) {
        return deviceService.findByDeviceId(deviceId);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(@PathVariable Long id, @RequestParam boolean trust) {
        return deviceService.updateTrustStatus(id, trust);
    }

    @DeleteMapping("/{id}")
    public String deleteDevice(@PathVariable Long id) {
        deviceService.getDevicesByUser(id).removeIf(d -> d.getId().equals(id));
        return "Device deleted successfully";
    }
}
