package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    @Autowired
    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord record) {
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public ViolationRecord resolveViolation(Long id) {
        ViolationRecord record = repo.findById(id).orElseThrow(() -> new RuntimeException("Violation not found"));
        record.setResolved(true);
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getUnresolved() {
        return repo.findByResolved(false);
    }

    @Override
    public List<ViolationRecord> getAll() {
        return repo.findAll();
    }
}
