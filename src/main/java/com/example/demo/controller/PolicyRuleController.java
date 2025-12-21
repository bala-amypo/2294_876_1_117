package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@CrossOrigin
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return policyRuleService.createRule(rule);
    }

    @GetMapping
    public List<PolicyRule> getAll() {
        return policyRuleService.getAllRules();
    }
}
