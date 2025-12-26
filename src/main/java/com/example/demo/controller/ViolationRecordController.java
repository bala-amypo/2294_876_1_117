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

    // 1️⃣ Primary POST
    @PostMapping
    public ViolationRecord create(@RequestBody ViolationRecord record) {
        return violationService.logViolation(record);
    }

    // 2️⃣ Secondary POST (same service method reused)
    @PostMapping("/secondary")
    public ViolationRecord createSecond(@RequestBody ViolationRecord record) {
        return violationService.logViolation(record);
    }

    // 3️⃣ GET all violations
    @GetMapping
    public List<ViolationRecord> getAll() {
        return violationService.getAllViolations();
    }

    // 4️⃣ GET violations by user
    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }

    // 5️⃣ GET unresolved violations
    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolved() {
        return violationService.getUnresolvedViolations();
    }

    // 6️⃣ Mark violation resolved
    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return violationService.markResolved(id);
    }
}
