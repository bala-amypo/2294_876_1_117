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

    @Override
    public ViolationRecord log(ViolationRecord record) {
        return violationRepo.save(record);
    }

    @Override
    public List<ViolationRecord> getByUserId(Long userId) {
        return violationRepo.findByUserId(userId);
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = violationRepo.findById(id).orElse(null);
        if (record == null) return null;
        record.setResolved(true);
        return violationRepo.save(record);
    }

    @Override
    public List<ViolationRecord> getUnresolved() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAll() {
        return violationRepo.findAll();
    }
}
