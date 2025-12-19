package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    @GetMapping("/lookup")
    public DeviceProfile lookup(@RequestParam String deviceId) {
        return new DeviceProfile();
    }
}
