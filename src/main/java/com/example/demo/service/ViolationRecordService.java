package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord v);

    List<ViolationRecord> getByUser(Long userId);

    ViolationRecord resolveViolation(Long id); // added

    List<ViolationRecord> getAllViolations();
}
