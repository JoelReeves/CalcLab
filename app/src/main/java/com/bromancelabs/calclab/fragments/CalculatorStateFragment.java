package com.bromancelabs.calclab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.NumberEvent;
import com.squareup.otto.Subscribe;

public class CalculatorStateFragment extends BaseFragment {

    public CalculatorStateFragment() {}

    public static CalculatorStateFragment newInstance() {
        return new CalculatorStateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Subscribe
    public void onNumberSelected(NumberEvent event) {
        postToBus(new DisplayEvent(event.getNumber()));
    }
}
