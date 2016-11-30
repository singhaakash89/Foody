package com.app.foody.oneui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.foody.menu.MenuContract;
import com.app.foody.oneui.R;
import com.app.foody.oneui.toast.ToastManager;

/**
 * Created by Aakash Singh on 29-11-2016.
 */

public class StandardMenuFragment extends Fragment implements MenuContract {
    private final String TAG = StandardMenuFragment.class.getSimpleName();
    private ToastManager toastManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        toastManager = ToastManager.getInstance();
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void selectItem() {

    }

    @Override
    public void selectQuantity() {

    }
}
