package com.bromancelabs.calclab;

import android.widget.EditText;

import com.bromancelabs.calclab.fragments.DisplayFragment;
import com.bromancelabs.calclab.support.ResourceLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.bromancelabs.calclab.support.Assert.assertViewIsVisible;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.SupportFragmentTestUtil.startFragment;

/**
 * Copyright (c) 2015 Bromance Labs, LLC.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DisplayFragmentTests {

    private DisplayFragment fragment;
    private EditText display;

    @Before
    public void setUp() throws Exception {
        fragment = DisplayFragment.newInstance();
        startFragment(fragment);

        display = (EditText) fragment.getView().findViewById(R.id.calculator_display);
    }

    @Test
    public void fragmentNotNull() throws Exception {
        assertNotNull(fragment);
    }

    @Test
    public void shouldHaveDisplay() throws Exception {
        assertViewIsVisible(fragment.getView().findViewById(R.id.calculator_display));
    }

    @Test
    public void shouldHaveDefaultDisplay() throws Exception {
        assertThat(display.getText().toString(), equalTo(ResourceLocator.getString(R.string.default_display)));
    }
}
