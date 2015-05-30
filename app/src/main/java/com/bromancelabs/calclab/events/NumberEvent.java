package com.bromancelabs.calclab.events;

public class NumberEvent extends BaseEvent {
    private String number;

    public NumberEvent(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
