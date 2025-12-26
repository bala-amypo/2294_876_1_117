package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return policyRuleService.createPolicy(rule);
    }

    @GetMapping("/{id}")
    public PolicyRule getById(@PathVariable Long id) {
        return policyRuleService.getPolicyById(id);
    }

    @GetMapping
    public List<PolicyRule> getAll() {
        return policyRuleService.getAllPolicies();
    }
}
