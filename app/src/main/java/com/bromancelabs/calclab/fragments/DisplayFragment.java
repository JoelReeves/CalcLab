package com.bromancelabs.calclab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bromancelabs.calclab.BaseApplication;
import com.bromancelabs.calclab.R;
import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.OperatorEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class DisplayFragment extends Fragment {
    private View view;
    private EditText display;

    public DisplayFragment() {}

    public static DisplayFragment newInstance() {
        return new DisplayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_display, container, false);

        display = (EditText) view.findViewById(R.id.calculator_display);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getAppBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getAppBus().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        view = null;
    }

    @Subscribe
    public void onDisplayEvent(DisplayEvent event) {
        setDisplay(event.getValue());
    }

    @Subscribe
    public void onOperatorDisplay(OperatorEvent event) {
        setDisplay(event.getOperator());
    }

    private void setDisplay(String displayString) {
        display.setText(displayString);
    }

    private Bus getAppBus() {
        return BaseApplication.getInstance().getBus();
    }
}
