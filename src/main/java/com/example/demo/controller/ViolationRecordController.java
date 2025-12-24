package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    public ResponseEntity<ViolationRecord> log(ViolationRecord v) {
        return ResponseEntity.ok(service.logViolation(v));
    }
}
