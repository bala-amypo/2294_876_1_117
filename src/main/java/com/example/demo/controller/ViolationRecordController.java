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
    public ViolationRecord logViolation(@RequestBody ViolationRecord violation) {
        return violationService.logViolation(violation);
    }

    @GetMapping("/{id}")
    public ViolationRecord getViolation(@PathVariable Long id) {
        return violationService.getAllViolations().stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Violation not found"));
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getViolationsByUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolved() {
        return violationService.getUnresolvedViolations();
    }

    @GetMapping
    public List<ViolationRecord> getAllViolations() {
        return violationService.getAllViolations();
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord markResolved(@PathVariable Long id) {
        return violationService.markResolved(id);
    }

    @DeleteMapping("/{id}")
    public String deleteViolation(@PathVariable Long id) {
        violationService.getAllViolations().removeIf(v -> v.getId().equals(id));
        return "Violation deleted successfully";
    }
}
