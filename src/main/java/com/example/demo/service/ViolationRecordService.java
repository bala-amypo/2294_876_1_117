package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {
    ViolationRecord log(ViolationRecord record);
    List<ViolationRecord> getAllViolations();
}
