package com.example.demo.service;

import com.example.demo.entity.LoginEvent;

import java.util.List;

public interface LoginEventService {

    void recordLogin(LoginEvent event);

    List<LoginEvent> getEventsByUser(Long userId);  // Ensure Long not long

    List<LoginEvent> getSuspiciousLogins(Long userId);

    List<LoginEvent> getAllEvents();
}
