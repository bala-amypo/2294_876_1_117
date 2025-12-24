package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
