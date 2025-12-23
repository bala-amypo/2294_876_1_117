package com.example.demo.util;

import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;

public class RuleEvaluationUtil {

    public static boolean evaluate(PolicyRule rule, Object event) {
        return true;
    }

    public static ViolationRecord buildViolation(PolicyRule rule, Object event) {
        ViolationRecord vr = new ViolationRecord();
        vr.setViolationType(rule.getRuleCode());
        vr.setSeverity(rule.getSeverity());
        vr.setDetails(rule.getDescription());
        return vr;
    }
}
