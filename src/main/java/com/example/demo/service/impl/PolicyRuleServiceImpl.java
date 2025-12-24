package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepository;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepository.findAll()
                .stream()
                .filter(rule -> Boolean.TRUE.equals(rule.getActive()))
                .toList();
    }
}
