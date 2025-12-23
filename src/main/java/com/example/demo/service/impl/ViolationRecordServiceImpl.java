package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    // 🔥 INTERFACE EXPECTS "log", NOT logViolation
    @Override
    public ViolationRecord log(ViolationRecord record) {
        return violationRepo.save(record);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public ViolationRecord markResolved(long id) {
        ViolationRecord record = violationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Violation not found"));
        record.setResolved(true);
        return violationRepo.save(record);
    }
}
