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
    public ViolationRecord logViolation(ViolationRecord record) {
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    @Override
    public ViolationRecord markResolved(long id) {
        ViolationRecord record = repo.findById(id).orElse(null);
        if (record == null) {
            return null;
        }
        record.setResolved(true);
        return repo.save(record);
    }

    @Override
    public ViolationRecord log(ViolationRecord record) {
        return logViolation(record);
    }
}
