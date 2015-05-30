package com.bromancelabs.calclab.fragments;

import android.support.v4.app.Fragment;

import com.bromancelabs.calclab.BaseApplication;
import com.bromancelabs.calclab.events.BaseEvent;
import com.squareup.otto.Bus;

public class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        getAppBus().register( this );
    }

    @Override
    public void onPause() {
        super.onPause();
        getAppBus().unregister( this );
    }

    protected Bus getAppBus() {
        return BaseApplication.getInstance().getBus();
    }

    protected void postToBus(BaseEvent event) {
        BaseApplication.postToBus(event);
    }
}
