package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface PolicyRuleRepository {
    PolicyRule save(PolicyRule r);
    List<PolicyRule> findByActiveTrue();
    List<PolicyRule> findAll();
}
