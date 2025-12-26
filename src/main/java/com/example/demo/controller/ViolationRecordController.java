package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    // ✅ POST /api/violations
    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord record) {
        return ResponseEntity.ok(violationService.logViolation(record));
    }

    // ✅ GET /api/violations/user/{userId}
    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }

    // ✅ PUT /api/violations/{id}/resolve
    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return violationService.markResolved(id);
    }

    // ✅ GET /api/violations/unresolved
    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return violationService.getUnresolvedViolations();
    }

    // ✅ GET /api/violations
    @GetMapping
    public List<ViolationRecord> getAll() {
        return violationService.getAllViolations();
    }
}
