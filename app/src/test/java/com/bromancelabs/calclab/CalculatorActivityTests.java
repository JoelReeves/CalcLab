package com.bromancelabs.calclab;

import android.support.v4.app.Fragment;

import com.bromancelabs.calclab.activities.CalculatorActivity;
import com.bromancelabs.calclab.events.BaseEvent;
import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.NumberEvent;
import com.bromancelabs.calclab.support.BusHelper;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CalculatorActivityTests {

    private CalculatorActivity activity;
    private Bus bus;
    private BusHelper busHelper;

    @Before
    public void setup() throws Exception {
       activity = Robolectric.buildActivity(CalculatorActivity.class)
               .create()
               .start()
               .resume()
               .get();

        bus = BaseApplication.getInstance().getBus();
        busHelper = new BusHelper();
        bus.register(busHelper);
    }

    @Test
    public void activityNotNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveDisplayFragment() throws Exception {
        assertNotNull(getFragmentById(R.id.display_fragment));
    }

    @Test
    public void shouldHaveButtonsFragmen() throws Exception {
        assertNotNull(getFragmentById(R.id.buttons_fragment));
    }

    @Test
    public void numberEventShouldFireDisplayEvent() throws Exception {
        String NUMBER_VALUE = "1";
        bus.post(new NumberEvent(NUMBER_VALUE));
        BaseEvent event = busHelper.getLastEvent();
        assertTrue(event instanceof DisplayEvent);
        assertThat(busHelper.numberOfEvents(), equalTo(2));
        assertThat(((DisplayEvent) event).getValue(), equalTo(NUMBER_VALUE));
    }

    Fragment getFragmentById(int id) {
        return activity.getSupportFragmentManager().findFragmentById(id);
    }
}
