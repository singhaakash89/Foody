package com.app.foody.oneui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.foody.oneui.R;
import com.app.foody.oneui.toast.ToastManager;
import com.app.foody.superuser.SuperUserContract;

/**
 * Created by Aakash Singh on 28-11-2016.
 */

public class StandardSuperUserFragment extends Fragment implements SuperUserContract {

    private final String TAG = StandardSuperUserFragment.class.getSimpleName();
    private ToastManager toastManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        toastManager = ToastManager.getInstance();
        return inflater.inflate(R.layout.fragment_superuser, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void showTraffic() {

    }

    @Override
    public void showTotalOrders() {

    }
}
