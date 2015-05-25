package com.bromancelabs.calclab;

import android.support.v4.app.Fragment;

import com.bromancelabs.calclab.activities.CalculatorActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

/**
 * Copyright (c) 2015 Bromance Labs, LLC.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    Fragment getFragmentById(int id) {
        return activity.getSupportFragmentManager().findFragmentById(id);
    }
}
