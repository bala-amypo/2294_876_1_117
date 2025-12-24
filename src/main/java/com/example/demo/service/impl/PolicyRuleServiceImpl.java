package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PolicyRule not found"));

        existing.setRuleName(rule.getRuleName());
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setActive(rule.isActive());

        return ruleRepository.save(existing);
    }

    @Override
    public Optional<PolicyRule> getRuleById(Long id) {
        return ruleRepository.findById(id);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }
}
