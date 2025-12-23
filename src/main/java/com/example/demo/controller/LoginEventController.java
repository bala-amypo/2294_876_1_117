package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    // POST /api/logins/record
    @PostMapping("/record")
    public ResponseEntity<LoginEvent> recordLogin(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(service.recordLogin(event));
    }

    // GET /api/logins/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getEventsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getEventsByUser(userId));
    }

    // GET /api/logins/suspicious/{userId}
    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspiciousLogins(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getSuspiciousLogins(userId));
    }

    // GET /api/logins
    @GetMapping
    public ResponseEntity<List<LoginEvent>> getAllEvents() {
        return ResponseEntity.ok(service.getAllEvents());
    }
}
