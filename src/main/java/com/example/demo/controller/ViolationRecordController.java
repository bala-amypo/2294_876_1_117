package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord record) {
        return record;
    }
}
