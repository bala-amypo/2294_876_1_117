package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
@CrossOrigin
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ViolationRecord create(@RequestBody ViolationRecord record) {
        return violationService.createViolation(record);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }
}
