package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    @Autowired
    private ViolationRecordRepository repo;

    @Override
    public List<ViolationRecord> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repo.findAll();
    }
}
