package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {

    ViolationRecord create(ViolationRecord record);

    List<ViolationRecord> getByUserId(Long userId);

    ViolationRecord resolve(Long id);

    List<ViolationRecord> getUnresolved();

    List<ViolationRecord> getAll();
}
