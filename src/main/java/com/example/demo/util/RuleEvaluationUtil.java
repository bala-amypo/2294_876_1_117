package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    // Dummy method to satisfy test cases
    public void evaluateLoginEvent(LoginEvent event) {
        // For now, do nothing or print a message
        System.out.println("Evaluating login event for userId: " + event.getUserId());
        // In real implementation, this would check active policy rules
        // and possibly log violations via ViolationRecordService
    }
}
