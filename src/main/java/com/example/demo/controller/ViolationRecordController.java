package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    @Autowired
    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    // Create/log a new violation
    @PostMapping("/log")
    public ResponseEntity<String> logViolation(@RequestBody ViolationRecord record) {
        service.log(record);  // void method
        return ResponseEntity.ok("Violation logged successfully");
    }

    // Mark a violation as resolved
    @PutMapping("/{id}/resolve")
    public ResponseEntity<String> markResolved(@PathVariable Long id) {
        service.markResolved(id);  // void method
        return ResponseEntity.ok("Violation marked as resolved");
    }

    // Get all violations by a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getByUser(@PathVariable Long userId) {
        List<ViolationRecord> records = service.byUser(userId);
        return ResponseEntity.ok(records);
    }

    // Get all unresolved violations
    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolved() {
        List<ViolationRecord> records = service.unresolved();
        return ResponseEntity.ok(records);
    }
}
