package com.bromancelabs.calclab.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bromancelabs.calclab.BaseApplication;
import com.bromancelabs.calclab.R;
import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.NumberEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAppBus().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getAppBus().unregister(this);
    }

    @Subscribe
    public void onNumberSelected(NumberEvent event) {
        BaseApplication.postToBus(new DisplayEvent(event.getNumber()));
    }

    private Bus getAppBus() {
        return BaseApplication.getInstance().getBus();
    }
}
