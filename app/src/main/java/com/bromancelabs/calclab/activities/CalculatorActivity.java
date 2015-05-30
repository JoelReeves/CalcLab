package com.bromancelabs.calclab.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bromancelabs.calclab.BaseApplication;
import com.bromancelabs.calclab.R;
import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.NumberEvent;
import com.bromancelabs.calclab.fragments.CalculatorStateFragment;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class CalculatorActivity extends AppCompatActivity {

    public static final String STATE_FRAGMENT_TAG = "CalculatorState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        getSupportFragmentManager().beginTransaction()
                .add(CalculatorStateFragment.newInstance(), STATE_FRAGMENT_TAG)
                .commit();
    }
}
