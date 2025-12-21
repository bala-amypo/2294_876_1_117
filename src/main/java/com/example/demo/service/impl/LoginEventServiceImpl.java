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
    private final RuleEvaluationUtil ruleEvaluator;

    public LoginEventServiceImpl(LoginEventRepository loginRepo, RuleEvaluationUtil ruleEvaluator) {
        this.loginRepo = loginRepo;
        this.ruleEvaluator = ruleEvaluator;
    }

    @Override
    public void recordLogin(LoginEvent event) {
        if (event.getIpAddress() == null || event.getDeviceId() == null) {
            throw new IllegalArgumentException("IP and Device ID are required");
        }

        if (event.getTimestamp() == null) {
            event.setTimestamp(LocalDateTime.now());
        }

        loginRepo.save(event);

        ruleEvaluator.evaluateLoginEvent(event);  // now exists
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
public List<LoginEvent> getSuspiciousLogins(Long userId) {
    return loginEventRepository.findSuspiciousByUserId(userId);
}

@Override
public List<LoginEvent> getAllLogins() {
    return loginEventRepository.findAll();
}

    
}
