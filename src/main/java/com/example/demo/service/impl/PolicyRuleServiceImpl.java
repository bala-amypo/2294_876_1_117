package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository policyRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository policyRepo) {
        this.policyRepo = policyRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return policyRepo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = policyRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));

        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());

        return policyRepo.save(existing);
    }

    @Override
    public PolicyRule getRuleById(Long id) {
        return policyRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return policyRepo.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return policyRepo.findByActiveTrue();
    }

    @Override
    public void deleteRule(Long id) {
        PolicyRule rule = policyRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));
        policyRepo.delete(rule);
    }
}
