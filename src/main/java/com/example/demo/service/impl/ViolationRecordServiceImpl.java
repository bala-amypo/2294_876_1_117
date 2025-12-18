package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord violation) {
        return repository.save(violation);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void markResolved(Long id) {
        ViolationRecord v = repository.findById(id).orElse(null);
        if (v != null) {
            v.setResolved(true);
            repository.save(v);
        }
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repository.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repository.findAll();
    }
}
