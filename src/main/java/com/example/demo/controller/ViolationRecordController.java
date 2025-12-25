package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ViolationRecord create(@RequestBody ViolationRecord violation) {
        return violationService.logViolation(violation);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return violationService.markResolved(id);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return violationService.getUnresolvedViolations();
    }

    @GetMapping
    public List<ViolationRecord> all() {
        return violationService.getAllViolations();
    }
}