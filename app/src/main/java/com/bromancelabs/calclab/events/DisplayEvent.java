package com.bromancelabs.calclab.events;

public class DisplayEvent extends BaseEvent {
    private String value;

    public DisplayEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
