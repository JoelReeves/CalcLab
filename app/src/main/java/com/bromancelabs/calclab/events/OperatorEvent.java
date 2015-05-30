package com.bromancelabs.calclab.events;

public class OperatorEvent extends BaseEvent {
    private String operator;

    public OperatorEvent(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
