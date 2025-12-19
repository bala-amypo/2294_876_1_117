package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;

    public LoginEventServiceImpl(LoginEventRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    @Override
    public LoginEvent logLogin(LoginEvent event) {
        return loginRepo.save(event);
    }

    @Override
    public List<LoginEvent> getLoginsByUser(Long userId) {
        return loginRepo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndSuspiciousTrue(userId);
    }

    @Override
    public List<LoginEvent> getAllLogins() {
        return loginRepo.findAll();
    }
}
