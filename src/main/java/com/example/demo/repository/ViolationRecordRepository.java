package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord v);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
}
