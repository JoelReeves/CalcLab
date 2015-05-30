package com.bromancelabs.calclab;

import android.widget.EditText;

import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.OperatorEvent;
import com.bromancelabs.calclab.fragments.DisplayFragment;
import com.bromancelabs.calclab.support.ResourceLocator;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.bromancelabs.calclab.support.Assert.assertViewIsVisible;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.SupportFragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DisplayFragmentTests {

    private DisplayFragment fragment;
    private EditText display;
    private static final String TEST_VALUE = "Test";
    private static final String TEST_OPERATOR = "%";
    private Bus bus;

    @Before
    public void setUp() throws Exception {
        fragment = DisplayFragment.newInstance();
        startFragment(fragment);

        display = (EditText) fragment.getView().findViewById(R.id.calculator_display);

        bus = BaseApplication.getInstance().getBus();
    }

    @Test
    public void fragmentNotNull() throws Exception {
        assertNotNull(fragment);
    }

    @Test
    public void shouldHaveDisplay() throws Exception {
        assertViewIsVisible(display);
    }

    @Test
    public void shouldHaveDefaultDisplay() throws Exception {
        assertValueDisplayed(ResourceLocator.getString(R.string.default_display));
    }

    @Test
    public void shouldUpdateDisplayAfterDisplayEvent() throws Exception {
        postDisplayEvent(TEST_VALUE);
        assertValueDisplayed(TEST_VALUE);
    }

    @Test
    public void shouldUpdateDisplayAfterOperatorEvent() throws Exception {
        postOperatorEvent(TEST_OPERATOR);
        assertValueDisplayed(TEST_OPERATOR);
    }

    private void assertValueDisplayed(String value) {
        assertThat(display.getText().toString(), equalTo(value));
    }

    private void postDisplayEvent(String value) {
        bus.post(new DisplayEvent(value));
    }

    private void postOperatorEvent(String value) {
        bus.post(new OperatorEvent(value));
    }
}
