package com.app.foody.oneui;

import com.app.foody.oneui.navDrawer.NavigationDrawerContract;

/**
 * Created by Aakash Singh on 28-11-2016.
 */
public class BaseActivityPresenter implements NavigationDrawerContract {

    private NavigationDrawerContract view;

    public BaseActivityPresenter(NavigationDrawerContract view) {
        this.view = view;
    }

    @Override
    public void inflateBreakfastFragment() {
        view.inflateBreakfastFragment();
    }

    @Override
    public void inflateStarterFragment() {
        view.inflateStarterFragment();
    }

    @Override
    public void inflateMainCourseFragment() {
        view.inflateMainCourseFragment();
    }

    @Override
    public void inflateSweetsFragment() {
        view.inflateSweetsFragment();
    }

    @Override
    public void inflateBeveragesFragment() {
        view.inflateBeveragesFragment();
    }

    @Override
    public void inflateAdminModeFragment() {
        view.inflateAdminModeFragment();
    }

    @Override
    public void inflateSuperUserModeFragment() {
        view.inflateSuperUserModeFragment();
    }
}
