package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/record")
    public ResponseEntity<Void> recordLogin(@RequestBody LoginEvent event) {
        loginService.recordLogin(event);  // corrected
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getEventsByUser(@PathVariable Long userId) {
        List<LoginEvent> events = loginService.getEventsByUser(userId);  // corrected
        return ResponseEntity.ok(events);
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> getAllEvents() {
        List<LoginEvent> events = loginService.getAllEvents();  // corrected
        return ResponseEntity.ok(events);
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspiciousLogins(@PathVariable Long userId) {
        List<LoginEvent> events = loginService.getSuspiciousLogins(userId);
        return ResponseEntity.ok(events);
    }
}
