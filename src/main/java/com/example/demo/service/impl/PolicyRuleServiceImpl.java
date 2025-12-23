package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import java.util.List;

public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PolicyRule create(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public PolicyRule update(Long id, PolicyRule rule) {
        PolicyRule existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        existing.setRuleCode(rule.getRuleCode());
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        return repository.save(existing);
    }

    @Override
    public List<PolicyRule> all() {
        return repository.findAll();
    }
}
