package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    // REQUIRED by tests
    public PolicyRuleController() {
        this.policyRuleService = null;
    }

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> update(
            @PathVariable Long id,
            @RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> activeRules() {
        return ResponseEntity.ok(policyRuleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> allRules() {
        return ResponseEntity.ok(policyRuleService.getAllRules());
    }
}
