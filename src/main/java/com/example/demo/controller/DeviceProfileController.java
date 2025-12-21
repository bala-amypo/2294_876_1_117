package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/device-profiles")
@CrossOrigin(origins = "*")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceProfile create(@RequestBody DeviceProfile profile) {
        return service.createProfile(profile);
    }

    @GetMapping
    public List<DeviceProfile> getAll() {
        return service.getAllProfiles();
    }

    @GetMapping("/{id}")
    public DeviceProfile getById(@PathVariable Long id) {
        return service.getProfileById(id);
    }

    @PutMapping("/{id}")
    public DeviceProfile update(@PathVariable Long id, @RequestBody DeviceProfile profile) {
        return service.updateProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProfile(id);
    }
}
