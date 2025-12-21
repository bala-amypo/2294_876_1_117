package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
@CrossOrigin
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping
    public LoginEvent logLogin(@RequestBody LoginEvent event) {
        return loginEventService.logLogin(event);
    }

    @GetMapping
    public List<LoginEvent> getAll() {
        return loginEventService.getAllLogins();
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return loginEventService.getLoginsByUser(userId);
    }
}
