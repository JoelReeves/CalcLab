package com.bromancelabs.calclab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bromancelabs.calclab.R;
import com.bromancelabs.calclab.events.NumberEvent;
import com.bromancelabs.calclab.events.OperatorEvent;

public class ButtonsFragment extends BaseFragment {

    private View view;

    public ButtonsFragment() {}

    public static ButtonsFragment newInstance() {
        return new ButtonsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_buttons, container, false);

        configureNumberButtons();
        configureOperatorButtons();
        configureEqualButton();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        view = null;
    }

    private void configureNumberButtons() {
        configureNumberButtonsWithId(R.id.button0);
        configureNumberButtonsWithId(R.id.button1);
        configureNumberButtonsWithId(R.id.button2);
        configureNumberButtonsWithId(R.id.button3);
        configureNumberButtonsWithId(R.id.button4);
        configureNumberButtonsWithId(R.id.button5);
        configureNumberButtonsWithId(R.id.button6);
        configureNumberButtonsWithId(R.id.button7);
        configureNumberButtonsWithId(R.id.button8);
        configureNumberButtonsWithId(R.id.button9);
    }

    private void configureNumberButtonsWithId(int id) {
        view.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = ((Button) v).getText().toString();
                postToBus(new NumberEvent(number));
            }
        });
    }

    private void configureOperatorButtons() {
        configureOperatorButtonsWithId(R.id.button_plus);
        configureOperatorButtonsWithId(R.id.button_minus);
        configureOperatorButtonsWithId(R.id.button_multiply);
        configureOperatorButtonsWithId(R.id.button_divide);
        configureOperatorButtonsWithId(R.id.button_mod);
    }

    private void configureOperatorButtonsWithId(int id) {
        view.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operator = ((Button) v).getText().toString();
                postToBus(new OperatorEvent(operator));
            }
        });
    }

    private void configureEqualButton() {
        configureEqualButtonWithId(R.id.button_equal);
    }

    private void configureEqualButtonWithId(int id) {
        view.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), ((Button) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
