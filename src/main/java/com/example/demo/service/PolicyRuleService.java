package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.*;

public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule rule);

    PolicyRule updateRule(Long id, PolicyRule updatedRule);

    List<PolicyRule> getActiveRules();

    Optional<PolicyRule> getRuleByCode(String ruleCode);

    List<PolicyRule> getAllRules();
}
