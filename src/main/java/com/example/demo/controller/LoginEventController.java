package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        return service.record(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return service.suspicious(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> getSuspicious(@PathVariable Long userId) {
        return service.suspicious(userId);
    }

    @GetMapping("/")
    public List<LoginEvent> getAll() {
        return service.all();
    }
}
