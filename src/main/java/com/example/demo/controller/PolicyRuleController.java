package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policyrules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    @Autowired
    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return service.create(rule);
    }

    @PutMapping("/{id}")
    public PolicyRule update(@PathVariable Long id, @RequestBody PolicyRule rule) {
        return service.update(id, rule);
    }

    @GetMapping
    public List<PolicyRule> all() {
        return service.all();
    }
}
