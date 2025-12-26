package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    // POST /api/policies
    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.createRule(rule));
    }

    // GET /api/policies
    @GetMapping
    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(policyRuleService.getAllRules());
    }

    // GET /api/policies/active
    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> active() {
        return ResponseEntity.ok(policyRuleService.getActiveRules());
    }

    // GET /api/policies/code/{code}
    @GetMapping("/code/{code}")
    public ResponseEntity<PolicyRule> getByCode(@PathVariable String code) {
        return policyRuleService.getRuleByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
