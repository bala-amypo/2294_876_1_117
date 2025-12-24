package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        return loginService.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return loginService.getEventsByUser(userId);
    }

@GetMapping("/suspicious/{userId}")
public ResponseEntity<List<LoginEvent>> suspicious(@PathVariable Long userId) {
    return ResponseEntity.ok(loginService.getSuspiciousLogins(userId));
}

}
