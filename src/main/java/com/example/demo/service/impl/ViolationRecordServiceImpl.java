package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    public ViolationRecord logViolation(ViolationRecord record) {
        return record;
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return new ArrayList<>();
    }
}
