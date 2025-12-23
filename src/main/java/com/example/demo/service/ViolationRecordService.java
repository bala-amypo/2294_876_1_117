package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    ViolationRecord log(ViolationRecord record);

    void markResolved(Long id);

    List<ViolationRecord> byUser(Long userId);

    List<ViolationRecord> unresolved();
}
