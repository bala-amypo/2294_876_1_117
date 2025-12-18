package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repository;
    private final RuleEvaluationUtil ruleEvaluationUtil;

   
    public LoginEventServiceImpl(LoginEventRepository repository,
                                 RuleEvaluationUtil ruleEvaluationUtil) {
        this.repository = repository;
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = repository.save(event);
        ruleEvaluationUtil.evaluateLoginEvent(saved);
        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repository.findByUserIdAndLoginStatus(userId, "SUCCESS");
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repository.findAll();
    }
}
