package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<PolicyRule> findAll() {
        return repo.findAll();
    }

    @Override
    public PolicyRule getRuleByCode(String code) {
        return repo.findByRuleCode(code)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }
}
