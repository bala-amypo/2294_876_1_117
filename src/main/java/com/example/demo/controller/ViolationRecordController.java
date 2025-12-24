package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord violation) {
        return service.logViolation(violation);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return service.getViolationsByUser(userId);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return service.markResolved(id);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return service.getUnresolvedViolations();
    }

    @GetMapping
    public List<ViolationRecord> all() {
        return service.getAllViolations();
    }
}
