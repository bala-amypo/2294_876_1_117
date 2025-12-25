package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity; // <-- add this import


import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

@PostMapping
public ResponseEntity<ViolationRecord> create(@RequestBody ViolationRecord violation) {
    ViolationRecord saved = violationService.logViolation(violation);
    return ResponseEntity.ok(saved);
}

@PutMapping("/{id}/resolve")
public ResponseEntity<ViolationRecord> resolve(@PathVariable Long id) {
    ViolationRecord resolved = violationService.markResolved(id);
    return ResponseEntity.ok(resolved);
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