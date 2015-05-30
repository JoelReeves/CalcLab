package com.bromancelabs.calclab;

import com.bromancelabs.calclab.events.BaseEvent;
import com.bromancelabs.calclab.events.DisplayEvent;
import com.bromancelabs.calclab.events.NumberEvent;
import com.bromancelabs.calclab.fragments.CalculatorStateFragment;
import com.bromancelabs.calclab.support.BusHelper;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.SupportFragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CalculatorStateFragmentTest {

    private CalculatorStateFragment fragment;

    private Bus bus;
    private BusHelper busHelper;

    @Before
    public void setup() throws Exception {
        fragment = CalculatorStateFragment.newInstance();
        startFragment(fragment);

        bus = BaseApplication.getInstance().getBus();
        busHelper = new BusHelper();
        bus.register(busHelper);
    }

    @Test
    public void fragmentNotNull() throws Exception {
        assertNotNull(fragment);
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
}
