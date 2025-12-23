package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logViolation(ViolationRecord record) {
        repository.save(record);
    }

    @Override
    public ViolationRecord markResolved(long id) {
        ViolationRecord vr = repository.findById(id).orElse(null);
        if (vr != null) {
            vr.setResolved(true);
            repository.save(vr);
        }
        return vr;
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repository.findByResolvedFalse();
    }
}
