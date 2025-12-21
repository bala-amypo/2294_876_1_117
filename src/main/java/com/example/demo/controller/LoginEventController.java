package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;

    // REQUIRED by tests
    public LoginEventController() {
        this.loginEventService = null;
    }

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(loginEventService.recordLogin(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getEventsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> suspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getSuspiciousLogins(userId));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> all() {
        return ResponseEntity.ok(loginEventService.getAllEvents());
    }
}
