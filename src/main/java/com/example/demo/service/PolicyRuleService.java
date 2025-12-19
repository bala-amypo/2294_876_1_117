package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule rule);

    PolicyRule updateRule(Long id, PolicyRule rule);

    PolicyRule getRuleById(Long id);

    List<PolicyRule> getAllRules();

    List<PolicyRule> getActiveRules();

    void deleteRule(Long id);
}
