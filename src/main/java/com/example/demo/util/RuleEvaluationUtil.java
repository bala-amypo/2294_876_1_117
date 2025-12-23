package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    // ✅ REQUIRED CONSTRUCTOR
    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    // ✅ REQUIRED METHOD
    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {
            ViolationRecord vr = new ViolationRecord();
            vr.setUserId(event.getUserId());
            vr.setPolicyRuleId(rule.getId());
            vr.setEventId(event.getId());
            vr.setViolationType("LOGIN_POLICY");
            vr.setSeverity(rule.getSeverity());
            vr.setDetectedAt(LocalDateTime.now());
            vr.setResolved(false);

            violationRepo.save(vr);
        }
    }
}
