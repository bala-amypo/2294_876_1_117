package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.util.RuleEvaluationUtil;

public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil evaluator;

    public LoginEventServiceImpl(LoginEventRepository repo, RuleEvaluationUtil evaluator) {
        this.repo = repo;
        this.evaluator = evaluator;
    }

    public LoginEvent recordLogin(LoginEvent e) {
        LoginEvent saved = repo.save(e);
        evaluator.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }
}
