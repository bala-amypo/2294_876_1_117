package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    @Autowired
    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public PolicyRule getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }
}
