package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    ViolationRecord log(ViolationRecord record);

    List<ViolationRecord> byUser(Long userId);

    List<ViolationRecord> unresolved();

    ViolationRecord markResolved(Long id);   // 🔥 REQUIRED BY CONTROLLER
}
