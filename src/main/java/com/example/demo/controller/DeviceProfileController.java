package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceProfile> getById(@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    }
    @GetMapping("/lookup/{deviceId}")
public DeviceProfile lookup(@PathVariable String deviceId) {
    return new DeviceProfile();
}

}
