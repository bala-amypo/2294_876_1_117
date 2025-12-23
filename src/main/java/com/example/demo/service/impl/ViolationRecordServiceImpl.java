package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import java.util.List;

public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
        record.setResolved(true);
        return repository.save(record);
    }

    @Override
    public List<ViolationRecord> byUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ViolationRecord> unresolved() {
        return repository.findByResolvedFalse();
    }
}
