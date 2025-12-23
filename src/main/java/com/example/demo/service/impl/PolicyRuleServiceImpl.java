package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PolicyRule not found"));
        existing.setRuleCode(rule.getRuleCode());
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());
        return repository.save(existing);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public PolicyRule getRuleByCode(String code) {
        return repository.findByRuleCode(code)
                .orElseThrow(() -> new RuntimeException("PolicyRule not found with code: " + code));
    }
}
