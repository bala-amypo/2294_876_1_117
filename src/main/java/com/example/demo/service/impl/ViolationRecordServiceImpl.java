package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return violationRepo.findByUserId(userId);
    }

     @Override
       public ViolationRecord markResolved(Long id) {
             ViolationRecord v = violationRepo.findById(id)
                             .orElseThrow(() -> new IllegalArgumentException("Violation not found"));

          v.setResolved(true);
          violationRepo.save(v);
          return v;
}


    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return violationRepo.findAll();
    }
}
