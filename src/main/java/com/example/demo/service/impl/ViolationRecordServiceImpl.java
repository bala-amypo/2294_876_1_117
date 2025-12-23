package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord log(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public ViolationRecord markResolved(long id) {
        ViolationRecord record = repository.findById(id).orElse(null);
        if (record != null) {
            record.setResolved(true);
            return repository.save(record);
        }
        return null;
    }
}
