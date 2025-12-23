package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        Optional<PolicyRule> existing = ruleRepo.findByRuleCode(rule.getRuleCode());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Rule code must be unique");
        }
        if (rule.getActive() == null) {
            rule.setActive(true);
        }
        return ruleRepo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule updated) {
        PolicyRule rule = ruleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));

        rule.setDescription(updated.getDescription());
        rule.setSeverity(updated.getSeverity());
        rule.setConditionsJson(updated.getConditionsJson());
        if (updated.getActive() != null) {
            rule.setActive(updated.getActive());
        }
        return ruleRepo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }

    @Override
    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return ruleRepo.findByRuleCode(ruleCode);
    }
    @GetMapping("/all")
public List<PolicyRule> all() {
    return ruleService.getAllRules();
}

}
