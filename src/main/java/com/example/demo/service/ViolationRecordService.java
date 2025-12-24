package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.*;

public interface ViolationRecordService {
    ViolationRecord logViolation(ViolationRecord v);
    List<ViolationRecord> getUnresolvedViolations();
    ViolationRecord markResolved(Long id);
}
