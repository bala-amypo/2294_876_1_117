package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService policyService;

    public PolicyRuleController(PolicyRuleService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return policyService.createRule(rule);
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return policyService.getActiveRules();
    }
}
