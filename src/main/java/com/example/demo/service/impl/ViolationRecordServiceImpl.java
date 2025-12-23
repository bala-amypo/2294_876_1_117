package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord log(ViolationRecord record) {
        return repo.save(record);
    }
    @Override
public ViolationRecord markResolved(long id) {
    Optional<ViolationRecord> optional = repo.findById(id);
    if (optional.isPresent()) {
        ViolationRecord record = optional.get();
        record.setResolved(true);
        return repo.save(record);
    }
    return null;
}

}
