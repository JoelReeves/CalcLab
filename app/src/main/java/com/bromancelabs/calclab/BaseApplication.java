package com.bromancelabs.calclab;

import android.app.Application;

import com.bromancelabs.calclab.events.BaseEvent;
import com.squareup.otto.Bus;

public class BaseApplication extends Application {

    private static BaseApplication instance = new BaseApplication();
    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        instance.bus = new Bus();
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public Bus getBus() {
        return bus;
    }

    public static void postToBus(BaseEvent event) {
        getInstance().getBus().post(event);
    }
}
