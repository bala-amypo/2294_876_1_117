package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;

    // REQUIRED by test cases
    public LoginEventController() {
        this.loginEventService = null;
    }

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping
    public ResponseEntity<LoginEvent> logLogin(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(loginEventService.logLogin(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getLoginsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getSuspiciousLogins(userId));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> getAll() {
        return ResponseEntity.ok(loginEventService.getAllLogins());
    }
}
