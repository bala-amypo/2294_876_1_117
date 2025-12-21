package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/{id}")
    public PolicyRule getRule(@PathVariable Long id) {
        return ruleService.getAllRules().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping
    public List<PolicyRule> getAllRules() {
        return ruleService.getAllRules();
    }

    @PutMapping("/{id}")
    public PolicyRule updateRule(@PathVariable Long id, @RequestBody PolicyRule updated) {
        return ruleService.updateRule(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteRule(@PathVariable Long id) {
        ruleService.getAllRules().removeIf(r -> r.getId().equals(id));
        return "Rule deleted successfully";
    }
}
