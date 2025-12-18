package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    @Autowired
    private ViolationRecordService service;

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord record) {
        return service.log(record);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return service.byUser(userId);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    @GetMapping
    public List<ViolationRecord> all() {
        return service.all();
    }
}
