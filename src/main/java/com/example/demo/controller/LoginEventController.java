package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {   // <-- must match file name
    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LoginEvent> recordLogin(@RequestBody LoginEvent loginEvent) {
        return ResponseEntity.ok(loginService.recordLogin(loginEvent));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getUserEvents(@PathVariable Long userId) {
        return ResponseEntity.ok(loginService.getEventsByUser(userId));
    }

    @GetMapping("/user/{userId}/suspicious")
    public ResponseEntity<List<LoginEvent>> getSuspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(loginService.getSuspiciousLogins(userId));
    }
}
