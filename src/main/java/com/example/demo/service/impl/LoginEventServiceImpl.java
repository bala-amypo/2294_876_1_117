package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepo;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepo) {
        this.loginEventRepo = loginEventRepo;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        return loginEventRepo.save(event);
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginEventRepo.findByUserId(userId);
    }
}
