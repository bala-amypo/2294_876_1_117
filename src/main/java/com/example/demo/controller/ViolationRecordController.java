package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationController {

    private final ViolationRecordService violationService;

    public ViolationController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    // POST 1 – create violation
    @PostMapping
    public ViolationRecord create(@RequestBody ViolationRecord record) {
        return violationService.create(record);
    }

    // POST 2 – create violation with severity (example second POST)
    @PostMapping("/severity")
    public ViolationRecord createWithSeverity(@RequestBody ViolationRecord record) {
        return violationService.create(record);
    }

    @GetMapping("/{id}")
    public ViolationRecord getById(@PathVariable Long id) {
        return violationService.getById(id);
    }

    @GetMapping
    public List<ViolationRecord> getAll() {
        return violationService.getAll();
    }
}
