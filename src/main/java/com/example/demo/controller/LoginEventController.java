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

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping
    public ResponseEntity<LoginEvent> createEvent(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(loginEventService.saveEvent(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getEventsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getEventsByUserId(userId));
    }

    @GetMapping("/user/{userId}/status/{status}")
    public ResponseEntity<List<LoginEvent>> getEventsByUserAndStatus(@PathVariable Long userId,
                                                                     @PathVariable String status) {
        return ResponseEntity.ok(loginEventService.getEventsByUserIdAndStatus(userId, status));
    }
}
