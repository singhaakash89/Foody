package com.app.foody.oneui.activities.admin;

/**
 * Created by Aakash Singh on 29-11-2016.
 */

public class StandardAdminPresenter implements AdminContract {

    private AdminContract view;

    public StandardAdminPresenter(AdminContract view) {
        this.view = view;
    }

    @Override
    public boolean uploadItem(int resId) {
        view.uploadItem(resId);
        return true;
    }

    @Override
    public boolean editItem(int resId) {
        view.editItem(resId);
        return false;
    }

    @Override
    public boolean orderManagement(int resId) {
        view.orderManagement(resId);
        return false;
    }

    @Override
    public boolean financeManagement(int resId) {
        view.financeManagement(resId);
        return false;
    }

    @Override
    public boolean developerCall(int resId) {
        view.developerCall(resId);
        return false;
    }
}
