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

   @GetMapping("/{deviceId}")
public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
    return deviceService.findByDeviceId(deviceId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}/trust")
public ResponseEntity<DeviceProfile> updateTrust(
        @PathVariable Long id,
        @RequestParam boolean trusted) {
    return ResponseEntity.ok(deviceService.updateTrustStatus(id, trusted));
}

}


