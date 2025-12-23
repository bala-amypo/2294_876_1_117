package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.service.PolicyRuleService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleEvaluator;
    private final PolicyRuleService ruleService;

    public LoginEventServiceImpl(LoginEventRepository loginRepo,
                                 RuleEvaluationUtil ruleEvaluator,
                                 PolicyRuleService ruleService) {
        this.loginRepo = loginRepo;
        this.ruleEvaluator = ruleEvaluator;
        this.ruleService = ruleService;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        if (event.getIpAddress() == null || event.getDeviceId() == null) {
            throw new IllegalArgumentException("IP address and Device ID cannot be null");
        }

        if (event.getTimestamp() == null) {
            event.setTimestamp(LocalDateTime.now());
        }

        LoginEvent savedEvent = loginRepo.save(event);

        // Fetch active rules and pass both event and rules to the evaluator
        List<PolicyRule> activeRules = ruleService.getActiveRules();
        ruleEvaluator.evaluateLoginEvent(savedEvent, activeRules);

        return savedEvent;
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
