package com.example.demo.service.impl;

import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;

    // EXISTING constructor
    public LoginEventServiceImpl(LoginEventRepository loginEventRepository) {
        this.loginEventRepository = loginEventRepository;
    }

    // ✅ ADD THIS constructor (for tests)
    public LoginEventServiceImpl(LoginEventRepository loginEventRepository,
                                 RuleEvaluationUtil ruleEvaluationUtil) {
        this.loginEventRepository = loginEventRepository;
    }
}
