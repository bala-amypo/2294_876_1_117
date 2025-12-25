package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleUtil; // added

    // Updated constructor
    public LoginEventServiceImpl(LoginEventRepository loginRepo, RuleEvaluationUtil ruleUtil) {
        this.loginRepo = loginRepo;
        this.ruleUtil = ruleUtil;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {

        if (event.getIpAddress() == null || event.getDeviceId() == null) {
            throw new IllegalArgumentException("IP Address and Device ID are required");
        }

        if (event.getLoginStatus() == null) {
            event.setLoginStatus("FAILED");
        }

        if (event.getTimestamp() == null) {
            event.setTimestamp(LocalDateTime.now());
        }

        // Example usage of ruleUtil if needed
        // ruleUtil.evaluateRules(event);

        return loginRepo.save(event);
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return loginRepo.findAll();
    }
}
