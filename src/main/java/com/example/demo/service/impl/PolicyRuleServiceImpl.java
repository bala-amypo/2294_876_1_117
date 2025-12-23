package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    public PolicyRule createRule(PolicyRule rule) {
        return rule;
    }

    public List<PolicyRule> getActiveRules() {
        return new ArrayList<>();
    }

    public List<PolicyRule> getAllRules() {
        return new ArrayList<>();
    }
}
