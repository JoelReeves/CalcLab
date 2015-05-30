package com.bromancelabs.calclab;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bromancelabs.calclab.events.BaseEvent;
import com.bromancelabs.calclab.events.NumberEvent;
import com.bromancelabs.calclab.events.OperatorEvent;
import com.bromancelabs.calclab.fragments.ButtonsFragment;
import com.bromancelabs.calclab.support.BusHelper;
import com.bromancelabs.calclab.support.ResourceLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static com.bromancelabs.calclab.support.Assert.assertViewIsVisible;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.SupportFragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ButtonsFragmentTests {

    private ButtonsFragment fragment;
    private BusHelper busHelper;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonMod;
    private Button buttonEqual;

    @Before
    public void setup() throws Exception {
        fragment = ButtonsFragment.newInstance();
        startFragment(fragment);

        busHelper = new BusHelper();
        BaseApplication.getInstance().getBus().register(busHelper);

        button0 = getButtonById(R.id.button0);
        button1 = getButtonById(R.id.button1);
        button2 = getButtonById(R.id.button2);
        button3 = getButtonById(R.id.button3);
        button4 = getButtonById(R.id.button4);
        button5 = getButtonById(R.id.button5);
        button6 = getButtonById(R.id.button6);
        button7 = getButtonById(R.id.button7);
        button8 = getButtonById(R.id.button8);
        button9 = getButtonById(R.id.button9);

        buttonPlus = getButtonById(R.id.button_plus);
        buttonMinus = getButtonById(R.id.button_minus);
        buttonMultiply = getButtonById(R.id.button_multiply);
        buttonDivide = getButtonById(R.id.button_divide);
        buttonMod = getButtonById(R.id.button_mod);
        buttonEqual = getButtonById(R.id.button_equal);
    }

    @Test
    public void fragmentNotNull() throws Exception {
        assertNotNull(fragment);
    }

    @Test
    public void shouldHaveButtons() throws Exception {
        assertViewIsVisible(getViewById(R.id.calculator_buttons));
    }

    @Test
    public void shouldHaveZeroButton() throws Exception {
        Button button0 = getButtonById(R.id.button0);
        assertViewIsVisible(button0);
        assertThat(getViewString(button0), equalTo(ResourceLocator.getString(R.string.button0)));
    }

    @Test
    public void shouldHaveOneButton() throws Exception {
        Button button1 = getButtonById(R.id.button1);
        assertViewIsVisible(button1);
        assertThat(getViewString(button1), equalTo(ResourceLocator.getString(R.string.button1)));
    }

    @Test
     public void shouldHaveTwoButton() throws Exception {
        Button button2 = getButtonById(R.id.button2);
        assertViewIsVisible(button2);
        assertThat(getViewString(button2), equalTo(ResourceLocator.getString(R.string.button2)));
    }

    @Test
    public void shouldHaveThreeButton() throws Exception {
        Button button3 = getButtonById(R.id.button3);
        assertViewIsVisible(button3);
        assertThat(getViewString(button3), equalTo(ResourceLocator.getString(R.string.button3)));
    }

    @Test
    public void shouldHaveFourButton() throws Exception {
        Button button4 = getButtonById(R.id.button4);
        assertViewIsVisible(button4);
        assertThat(getViewString(button4), equalTo(ResourceLocator.getString(R.string.button4)));
    }

    @Test
    public void shouldHaveFiveButton() throws Exception {
        Button button5 = getButtonById(R.id.button5);
        assertViewIsVisible(button5);
        assertThat(getViewString(button5), equalTo(ResourceLocator.getString(R.string.button5)));
    }

    @Test
    public void shouldHaveSixButton() throws Exception {
        Button button6 = getButtonById(R.id.button6);
        assertViewIsVisible(button6);
        assertThat(getViewString(button6), equalTo(ResourceLocator.getString(R.string.button6)));
    }

    @Test
    public void shouldHaveSevenButton() throws Exception {
        Button button7 = getButtonById(R.id.button7);
        assertViewIsVisible(button7);
        assertThat(getViewString(button7), equalTo(ResourceLocator.getString(R.string.button7)));
    }

    @Test
    public void shouldHaveEightButton() throws Exception {
        Button button8 = getButtonById(R.id.button8);
        assertViewIsVisible(button8);
        assertThat(getViewString(button8), equalTo(ResourceLocator.getString(R.string.button8)));
    }

    @Test
    public void shouldHaveNineButton() throws Exception {
        Button button9 = getButtonById(R.id.button9);
        assertViewIsVisible(button9);
        assertThat(getViewString(button9), equalTo(ResourceLocator.getString(R.string.button9)));
    }

    @Test
    public void shouldHavePlusButton() throws Exception {
        Button plus = getButtonById(R.id.button_plus);
        assertViewIsVisible(plus);
        assertThat(getViewString(plus), equalTo(ResourceLocator.getString(R.string.button_plus)));
    }

    @Test
    public void shouldHaveMinusButton() throws Exception {
        Button minus = getButtonById(R.id.button_minus);
        assertViewIsVisible(minus);
        assertThat(getViewString(minus), equalTo(ResourceLocator.getString(R.string.button_minus)));
    }

    @Test
    public void shouldHaveMultiplyButton() throws Exception {
        Button multiply = getButtonById(R.id.button_multiply);
        assertViewIsVisible(multiply);
        assertThat(getViewString(multiply), equalTo(ResourceLocator.getString(R.string.button_multiply)));
    }

    @Test
    public void shouldHaveDivideButton() throws Exception {
        Button divide = getButtonById(R.id.button_divide);
        assertViewIsVisible(divide);
        assertThat(getViewString(divide), equalTo(ResourceLocator.getString(R.string.button_divide)));
    }

    @Test
    public void shouldHaveModButton() throws Exception {
        Button mod = getButtonById(R.id.button_mod);
        assertViewIsVisible(mod);
        assertThat(getViewString(mod), equalTo(ResourceLocator.getString(R.string.button_mod)));
    }

    @Test
    public void shouldHaveEqualButton() throws Exception {
        Button equal = getButtonById(R.id.button_equal);
        assertViewIsVisible(equal);
        assertThat(getViewString(equal), equalTo(ResourceLocator.getString(R.string.button_equal)));
    }

    @Test
    public void shouldHaveClearButton() throws Exception {
        Button clear = getButtonById(R.id.button_clear);
        assertViewIsVisible(clear);
        assertThat(getViewString(clear), equalTo(ResourceLocator.getString(R.string.button_clear)));
    }

    @Test
    public void button0ShouldPostEvent() throws Exception {
        verifyNumberEvent(button0);
    }

    @Test
    public void button1ShouldPostEvent() throws Exception {
        verifyNumberEvent(button1);
    }

    @Test
    public void button2ShouldPostEvent() throws Exception {
        verifyNumberEvent(button2);
    }

    @Test
    public void button3ShouldPostEvent() throws Exception {
        verifyNumberEvent(button3);
    }

    @Test
    public void button4ShouldPostEvent() throws Exception {
        verifyNumberEvent(button4);
    }

    @Test
    public void button5ShouldPostEvent() throws Exception {
        verifyNumberEvent(button5);
    }

    @Test
    public void button6ShouldPostEvent() throws Exception {
        verifyNumberEvent(button6);
    }

    @Test
    public void button7ShouldPostEvent() throws Exception {
        verifyNumberEvent(button7);
    }

    @Test
    public void button8ShouldPostEvent() throws Exception {
        verifyNumberEvent(button8);
    }

    @Test
    public void button9ShouldPostEvent() throws Exception {
        verifyNumberEvent(button9);
    }

    void verifyNumberEvent(Button button) {
        button.performClick();
        BaseEvent event = busHelper.getLastEvent();
        assertTrue(event instanceof NumberEvent);
        assertThat(((NumberEvent) event).getNumber(), equalTo(button.getText()));
    }

    @Test
    public void buttonPlusShouldPostEvent() throws Exception {
        verifyOperatorButtonEvent(buttonPlus);
    }

    @Test
    public void buttonMinusShouldPostEvent() throws Exception {
        verifyOperatorButtonEvent(buttonMinus);
    }

    @Test
    public void buttonMultiplyShouldPostEvent() throws Exception {
        verifyOperatorButtonEvent(buttonMultiply);
    }

    @Test
    public void buttonDivideShouldPostEvent() throws Exception {
        verifyOperatorButtonEvent(buttonDivide);
    }

    @Test
    public void buttonModShouldPostEvent() throws Exception {
        verifyOperatorButtonEvent(buttonMod);
    }

    void verifyOperatorButtonEvent(Button button) {
        button.performClick();
        BaseEvent event = busHelper.getLastEvent();
        assertTrue(event instanceof OperatorEvent);
        assertThat(((OperatorEvent) event).getOperator(), equalTo(button.getText()));
    }

    @Test
    public void buttonEqualShouldToast() throws Exception {
        verifyPostEventAfterEqualClick(buttonEqual);
    }

    void verifyPostEventAfterEqualClick(Button button) {
        button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo(button.getText()));
    }

    private View getViewById(int id) {
        return fragment.getView().findViewById(id);
    }

    private Button getButtonById(int id) {
        return (Button) getViewById(id);
    }

    private String getViewString(TextView view) {
        return view.getText().toString();
    }
}
