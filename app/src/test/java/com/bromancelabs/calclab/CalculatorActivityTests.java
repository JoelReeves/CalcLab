package com.bromancelabs.calclab;

import android.support.v4.app.Fragment;

import com.bromancelabs.calclab.activities.CalculatorActivity;
import com.bromancelabs.calclab.fragments.CalculatorStateFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CalculatorActivityTests {

    private CalculatorActivity activity;

    @Before
    public void setup() throws Exception {
       activity = Robolectric.buildActivity(CalculatorActivity.class)
               .create()
               .start()
               .resume()
               .get();
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
    public void shouldHaveCalculatorStateFragment() throws Exception {
        Fragment fragment = getStateFragment();
        assertNotNull(fragment);
        assertTrue(fragment instanceof CalculatorStateFragment);
    }

    private Fragment getFragmentById(int id) {
        return activity.getSupportFragmentManager().findFragmentById(id);
    }

    private Fragment getStateFragment() {
        return activity.getSupportFragmentManager().
                findFragmentByTag(CalculatorActivity.STATE_FRAGMENT_TAG);
    }
}
