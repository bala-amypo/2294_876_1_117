package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PolicyRule {

    @Id
    private Long id;

    private String code;
    private String description;
    private String severity;
    private boolean active = true;
    private String conditionsJson;  // This is needed for RuleEvaluationUtil

    public PolicyRule() {}

    public PolicyRule(String code, String description, String severity, boolean active, String conditionsJson) {
        this.code = code;
        this.description = description;
        this.severity = severity;
        this.active = active;
        this.conditionsJson = conditionsJson;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getConditionsJson() { return conditionsJson; }
    public void setConditionsJson(String conditionsJson) { this.conditionsJson = conditionsJson; }
}
