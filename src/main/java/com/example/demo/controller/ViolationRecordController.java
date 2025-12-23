package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationRecordService;

    public ViolationRecordController(ViolationRecordService violationRecordService) {
        this.violationRecordService = violationRecordService;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord record) {
        return ResponseEntity.ok(violationRecordService.log(record));
    }
}
