package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final ViolationRecordService violationService;

    public RuleEvaluationUtil(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    /**
     * Evaluates active policy rules for a login event and logs violations.
     * @param event The login event to evaluate.
     * @param activeRules List of active PolicyRules.
     */
    public void evaluateLoginEvent(LoginEvent event, List<PolicyRule> activeRules) {
        if (activeRules == null || activeRules.isEmpty()) return;

        for (PolicyRule rule : activeRules) {
            boolean violationDetected = false;

            // Example rule evaluation logic:
            if ("FAILED_LOGIN_LIMIT".equals(rule.getRuleCode()) && "FAILED".equals(event.getLoginStatus())) {
                violationDetected = true;
            }

            if (violationDetected) {
                ViolationRecord record = new ViolationRecord();
                record.setUserId(event.getUserId());
                record.setEventId(event.getId());
                record.setPolicyRuleId(rule.getId());
                record.setViolationType("LOGIN_VIOLATION");
                record.setSeverity(rule.getSeverity());
                record.setDetails("Violation triggered by rule: " + rule.getRuleCode());
                record.setDetectedAt(LocalDateTime.now());
                record.setResolved(false);

                violationService.logViolation(record);
            }
        }
    }
}
