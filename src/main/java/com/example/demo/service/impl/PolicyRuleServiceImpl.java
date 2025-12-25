package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    @Autowired
    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return repo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule ruleDetails) {
        PolicyRule rule = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy Rule not found"));
        rule.setRuleName(ruleDetails.getRuleName());
        rule.setConditionsJson(ruleDetails.getConditionsJson());
        rule.setActive(ruleDetails.getActive());
        return repo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repo.findByActive(true);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }
}
