package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {
    LoginEvent saveEvent(LoginEvent event);
    List<LoginEvent> getEventsByUserId(Long userId);
    List<LoginEvent> getEventsByUserIdAndStatus(Long userId, String status);
    List<LoginEvent> getAllEvents();
}
