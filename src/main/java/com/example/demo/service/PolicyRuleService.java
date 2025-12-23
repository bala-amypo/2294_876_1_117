package com.example.demo.service;

import com.example.demo.entity.PolicyRule;

import java.util.List;
import java.util.Optional;

public interface PolicyRuleService {

    List<PolicyRule> getAllRules();

    Optional<PolicyRule> getRuleByCode(String ruleCode);
}
