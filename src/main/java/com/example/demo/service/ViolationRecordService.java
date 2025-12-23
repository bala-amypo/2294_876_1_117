package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {
    ViolationRecord markResolved(Long id);
    List<ViolationRecord> byUser(Long userId);
    List<ViolationRecord> unresolved();

    // Missing method
    ViolationRecord log(ViolationRecord record);

    // Optional: get all violations
    List<ViolationRecord> getAllViolations();
}
