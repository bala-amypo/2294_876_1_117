package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    // Constructor injection
    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Violation not found"));
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

    @Override
    public ViolationRecord log(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repository.findAll();
    }
}
