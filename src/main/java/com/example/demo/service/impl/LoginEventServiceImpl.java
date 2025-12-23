package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.service.PolicyRuleService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepo;
    private final RuleEvaluationUtil ruleUtil;
    private final PolicyRuleService policyRuleService;

    // EXISTING constructor
    public LoginEventServiceImpl(LoginEventRepository loginEventRepo, RuleEvaluationUtil ruleUtil, PolicyRuleService policyRuleService) {
        this.loginEventRepo = loginEventRepo;
        this.ruleUtil = ruleUtil;
        this.policyRuleService = policyRuleService;
    }

    // ✅ NEW overloaded constructor for tests
    public LoginEventServiceImpl(LoginEventRepository loginEventRepo, RuleEvaluationUtil ruleUtil) {
        this.loginEventRepo = loginEventRepo;
        this.ruleUtil = ruleUtil;
        this.policyRuleService = null;
    }

    @Override
    public void processLoginEvent(LoginEvent event) {
        loginEventRepo.save(event);
        ruleUtil.evaluateLoginEvent(event); // uses overloaded method if list not provided
    }
}
