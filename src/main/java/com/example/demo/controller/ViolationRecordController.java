package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/log")
    public ViolationRecord log(@RequestBody ViolationRecord record) {
        return service.log(record);
    }

    @PutMapping("/{id}/resolve")
    public void markResolved(@PathVariable Long id) {
        service.markResolved(id);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return service.byUser(userId);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return service.unresolved();
    }
}
