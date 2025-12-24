package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord create(ViolationRecord record) {
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public ViolationRecord resolve(Long id) {
        ViolationRecord v = repo.findById(id).orElseThrow();
        v.setResolved(true);
        return repo.save(v);
    }

    @Override
    public List<ViolationRecord> getUnresolved() {
        return repo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAll() {
        return repo.findAll();
    }
}
