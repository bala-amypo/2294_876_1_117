package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepo;
    private final RuleEvaluationUtil ruleUtil;
    private final PolicyRuleService policyRuleService;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepo, RuleEvaluationUtil ruleUtil, PolicyRuleService policyRuleService) {
        this.loginEventRepo = loginEventRepo;
        this.ruleUtil = ruleUtil;
        this.policyRuleService = policyRuleService;
    }

    @Override
    public LoginEvent processEvent(LoginEvent event) {
        List<?> rules = policyRuleService.getAll(); // replace ? with PolicyRule
        ruleUtil.evaluateLoginEvent(event, rules);
        return loginEventRepo.save(event);
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return loginEventRepo.findAll();
    }
}
