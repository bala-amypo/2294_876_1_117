package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    // REQUIRED constructor (tests + Spring)
    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository,
                              ViolationRecordRepository violationRecordRepository) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    // REQUIRED method signature
    public void evaluateLoginEvent(LoginEvent event) {

        if (event == null || event.getUserId() == null) {
            return;
        }

        List<PolicyRule> activeRules = policyRuleRepository.findByActiveTrue();

        for (PolicyRule rule : activeRules) {

            ViolationRecord violation = new ViolationRecord();
            violation.setUserId(event.getUserId());
            violation.setPolicyRuleId(rule.getId());
            violation.setEventId(event.getId());
            violation.setViolationType(rule.getRuleCode());
            violation.setDetails("Policy rule violated: " + rule.getDescription());
            violation.setSeverity(rule.getSeverity());
            violation.setResolved(false); // detectedAt handled by @PrePersist

            violationRecordRepository.save(violation);
        }
    }
}
