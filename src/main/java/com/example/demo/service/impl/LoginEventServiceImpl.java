package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleEvaluator;

    public LoginEventServiceImpl(LoginEventRepository loginRepo, RuleEvaluationUtil ruleEvaluator) {
        this.loginRepo = loginRepo;
        this.ruleEvaluator = ruleEvaluator;
    }

    @Override
    public List<LoginEvent> getEventsByUser(long userId) {  // match primitive long
        return loginRepo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        if (event.getIpAddress() == null || event.getDeviceId() == null) {
            throw new IllegalArgumentException("IP address and Device ID are required");
        }

        if (event.getTimestamp() == null) {
            event.setTimestamp(java.time.LocalDateTime.now());
        }

        LoginEvent saved = loginRepo.save(event);

        ruleEvaluator.evaluateLoginEvent(saved);

        return saved;
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return loginRepo.findAll();
    }
}
