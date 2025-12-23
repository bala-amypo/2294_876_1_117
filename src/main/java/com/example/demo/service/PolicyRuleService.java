package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleService {
    PolicyRule create(PolicyRule rule);         // called by controller/tests
    PolicyRule update(Long id, PolicyRule rule);
    List<PolicyRule> all();
}
