package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationRecordService;

    public ViolationRecordController(ViolationRecordService violationRecordService) {
        this.violationRecordService = violationRecordService;
    }

    @PostMapping
    public ViolationRecord logViolation(@RequestBody ViolationRecord record) {
        return violationRecordService.logViolation(record);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return violationRecordService.getByUser(userId);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return violationRecordService.resolveViolation(id);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return violationRecordService.getUnresolved();
    }

    @GetMapping
    public List<ViolationRecord> getAll() {
        return violationRecordService.getAll();
    }
}
