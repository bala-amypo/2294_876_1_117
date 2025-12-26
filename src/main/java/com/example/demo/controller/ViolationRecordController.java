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
    public ViolationRecord create(@RequestBody ViolationRecord record) {
        return violationService.createViolation(record);
    }

    @PostMapping("/secondary")
    public ViolationRecord createSecond(@RequestBody ViolationRecord record) {
        return violationService.createViolation(record);
    }

    @GetMapping("/{id}")
    public ViolationRecord getById(@PathVariable Long id) {
        return violationService.getViolationById(id);
    }

    @GetMapping
    public List<ViolationRecord> getAll() {
        return violationService.getAllViolations();
    }
}
