package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        ruleRepo.findByRuleCode(rule.getRuleCode())
                .ifPresent(r -> {
                    throw new RuntimeException("Rule code already exists");
                });

        return ruleRepo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule updatedRule) {
        PolicyRule rule = ruleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));

        rule.setDescription(updatedRule.getDescription());
        rule.setSeverity(updatedRule.getSeverity());
        rule.setConditionsJson(updatedRule.getConditionsJson());
        rule.setActive(updatedRule.getActive());

        return ruleRepo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return ruleRepo.findByRuleCode(ruleCode);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
