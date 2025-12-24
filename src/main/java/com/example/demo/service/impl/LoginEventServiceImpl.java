package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository) {
        this.loginEventRepository = loginEventRepository;
    }

    @Override
    public List<LoginEvent> getEventsByUserIdAndStatus(Long userId, String loginStatus) {
        return loginEventRepository.findByUserIdAndLoginStatus(userId, loginStatus);
    }

    @Override
    public List<LoginEvent> getEventsByUserId(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }

    @Override
    public LoginEvent saveEvent(LoginEvent event) {
        return loginEventRepository.save(event);
    }
}
