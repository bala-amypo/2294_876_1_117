package com.example.demo.util;

import org.springframework.stereotype.Component;
import com.example.demo.entity.LoginEvent;
import java.util.List;

/**
 * Utility class for evaluating login events and rules.
 * This is a Spring-managed bean, so it can be injected into services.
 */
@Component
public class RuleEvaluationUtil {

    // Default constructor
    public RuleEvaluationUtil() {
    }

    /**
     * Evaluates a single login event.
     * @param event the LoginEvent to evaluate
     * @return true if the event passes the evaluation, false otherwise
     */
    public boolean evaluateLoginEvent(LoginEvent event) {
        // Dummy logic: always return true for now
        return true;
    }

    /**
     * Evaluates multiple login events.
     * @param events list of LoginEvent objects
     * @return number of events that pass evaluation
     */
    public int evaluateLoginEvents(List<LoginEvent> events) {
        int count = 0;
        for (LoginEvent event : events) {
            if (evaluateLoginEvent(event)) {
                count++;
            }
        }
        return count;
    }

    // You can add more methods here for other rule evaluations as needed
}
