package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {

    LoginEvent logLogin(LoginEvent event);

    List<LoginEvent> getLoginsByUser(Long userId);

    List<LoginEvent> getSuspiciousLogins(Long userId);

    List<LoginEvent> getAllLogins();

    void recordLogin(LoginEvent event);
List<LoginEvent> getEventsByUser(long userId);
}
