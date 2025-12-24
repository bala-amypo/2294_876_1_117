package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public PolicyRule update(@PathVariable Long id,
                             @RequestBody PolicyRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<PolicyRule> active() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<PolicyRule> all() {
        return service.getAllRules();
    }
}
