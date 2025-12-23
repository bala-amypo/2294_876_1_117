package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public PolicyRule create(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public PolicyRule update(Long id, PolicyRule rule) {
        PolicyRule existing = ruleRepo.findById(id).orElseThrow();
        existing.setDescription(rule.getDescription());
        existing.setConditionsJson(rule.getConditionsJson());
        return ruleRepo.save(existing);
    }

    @Override
    public List<PolicyRule> all() {
        return ruleRepo.findAll();
    }
}
