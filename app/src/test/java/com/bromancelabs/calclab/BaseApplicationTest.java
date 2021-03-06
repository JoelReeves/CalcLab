package com.bromancelabs.calclab;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class BaseApplicationTest {

    private BaseApplication application;

    @Before
    public void setup() throws Exception {
        application = BaseApplication.getInstance();
    }

    @Test
    public void applicationNotNull() throws Exception {
        assertNotNull(application);
    }

    @Test
    public void shouldHaveBus() throws Exception {
        assertNotNull(application.getBus());
    }
}
