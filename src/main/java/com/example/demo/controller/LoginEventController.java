package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
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
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        return loginService.recordLogin(event);
    }

    @GetMapping("/{id}")
    public LoginEvent getLoginEvent(@PathVariable Long id) {
        return loginService.getAllEvents().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Login event not found"));
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getEventsByUser(@PathVariable Long userId) {
        return loginService.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> getSuspicious(@PathVariable Long userId) {
        return loginService.getSuspiciousLogins(userId);
    }

    @GetMapping
    public List<LoginEvent> getAllEvents() {
        return loginService.getAllEvents();
    }

    @DeleteMapping("/{id}")
    public String deleteLoginEvent(@PathVariable Long id) {
        loginService.getAllEvents().removeIf(e -> e.getId().equals(id));
        return "Login event deleted successfully";
    }
}
