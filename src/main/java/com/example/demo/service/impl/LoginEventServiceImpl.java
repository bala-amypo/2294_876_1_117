package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.service.PolicyRuleService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;
    private final PolicyRuleService policyRuleService;
    private final RuleEvaluationUtil ruleEvaluationUtil;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository,
                                 PolicyRuleService policyRuleService,
                                 RuleEvaluationUtil ruleEvaluationUtil) {
        this.loginEventRepository = loginEventRepository;
        this.policyRuleService = policyRuleService;
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent loginEvent) {
        List<PolicyRule> rules = policyRuleService.findAll();
        ruleEvaluationUtil.evaluateLoginEvent(loginEvent, rules);
        return loginEventRepository.save(loginEvent);
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return loginEventRepository.findAll();
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginEventRepository.findAll(); // filter handled by rules
    }
}
