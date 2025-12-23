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
    public PolicyRule create(PolicyRule rule) {
        return repo.save(rule);
    }

    @Override
    public PolicyRule update(Long id, PolicyRule rule) {
        rule.setId(id);
        return repo.save(rule);
    }

    @Override
    public List<PolicyRule> all() {
        return repo.findAll();
    }
}
