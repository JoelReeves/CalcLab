package com.bromancelabs.calclab.support;

import com.bromancelabs.calclab.events.BaseEvent;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class BusHelper {

    private ArrayList<BaseEvent> events = new ArrayList<>();

    public BaseEvent getLastEvent() {
        if (!events.isEmpty()) {
            return events.get(events.size() - 1);
        }
        return null;
    }

    @Subscribe
    public void onAnyEvent(BaseEvent event) {
        events.add(event);
    }

    public int numberOfEvents() {
        return events.size();
    }
}
