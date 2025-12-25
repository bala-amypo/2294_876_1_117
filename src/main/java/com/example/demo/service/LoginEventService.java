package com.example.demo.service;

import com.example.demo.entity.LoginEvent;

import java.util.List;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent event); // added

    List<LoginEvent> getEventsByUser(Long userId);

    List<LoginEvent> getSuspiciousEvents(Long userId); // added

    List<LoginEvent> getAllEvents();
}
