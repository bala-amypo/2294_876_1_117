package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    @Autowired
    private LoginEventService service;

    @PostMapping
    public LoginEvent record(@RequestBody LoginEvent event) {
        return service.record(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> suspicious(@PathVariable Long userId) {
        return service.suspicious(userId);
    }

    @GetMapping
    public List<LoginEvent> all() {
        return service.all();
    }
}
