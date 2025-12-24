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
    public ViolationRecord create(@RequestBody ViolationRecord record) {
        return service.create(record); // ❌ NOT Object
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return service.getUnresolved();
    }

    @GetMapping
    public List<ViolationRecord> all() {
        return service.getAll();
    }
}
