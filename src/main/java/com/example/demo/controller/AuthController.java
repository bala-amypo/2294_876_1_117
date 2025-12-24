package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "Logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        return service.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> byUser(@PathVariable Long userId) {
        return service.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> suspicious(@PathVariable Long userId) {
        return service.getSuspiciousLogins(userId);
    }

    @GetMapping
    public List<LoginEvent> all() {
        return service.getAllEvents();
    }
}
