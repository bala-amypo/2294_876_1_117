package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {

    LoginEvent record(LoginEvent event);

    List<LoginEvent> suspicious(Long userId);

    List<LoginEvent> all();
}
