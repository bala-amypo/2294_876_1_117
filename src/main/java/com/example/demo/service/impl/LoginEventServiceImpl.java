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
    public LoginEvent logLogin(LoginEvent event) {
        return loginEventRepository.save(event);
    }

    @Override
    public List<LoginEvent> getLoginsByUser(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getAllLogins() {
        return loginEventRepository.findAll();
    }
}
