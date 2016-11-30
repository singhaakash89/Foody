package com.app.foody.oneui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.foody.oneui.BaseActivity;
import com.app.foody.oneui.R;
import com.app.foody.oneui.activities.admin.AdminBaseActivity;
import com.app.foody.oneui.activities.admin.AdminContract;
import com.app.foody.oneui.toast.ToastManager;

/**
 * Created by Aakash Singh on 24-05-2016.
 */
public class StandardAdminFragment extends Fragment implements View.OnClickListener {
    private final String TAG = StandardAdminFragment.class.getSimpleName();
    private ToastManager toastManager;
    private LinearLayout uploadItem;
    private LinearLayout editItem;
    private LinearLayout orderManagment;
    private LinearLayout financeManagement;
    private LinearLayout developerCall;
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        toastManager = ToastManager.getInstance();
        return inflater.inflate(R.layout.fragment_admin, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intent = new Intent(BaseActivity.getContext(), AdminBaseActivity.class);
        uploadItem = (LinearLayout) getActivity().findViewById(R.id.upload_item_ll);
        editItem = (LinearLayout) getActivity().findViewById(R.id.edit_item_ll);
        orderManagment = (LinearLayout) getActivity().findViewById(R.id.order_management_ll);
        financeManagement = (LinearLayout) getActivity().findViewById(R.id.finance_management_ll);
        developerCall = (LinearLayout) getActivity().findViewById(R.id.developer_call_ll);

        uploadItem.setOnClickListener(this);
        editItem.setOnClickListener(this);
        orderManagment.setOnClickListener(this);
        financeManagement.setOnClickListener(this);
        developerCall.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        intent = new Intent(BaseActivity.getContext(), AdminBaseActivity.class);
        uploadItem = (LinearLayout) getActivity().findViewById(R.id.upload_item_ll);
        editItem = (LinearLayout) getActivity().findViewById(R.id.edit_item_ll);
        orderManagment = (LinearLayout) getActivity().findViewById(R.id.order_management_ll);
        financeManagement = (LinearLayout) getActivity().findViewById(R.id.finance_management_ll);
        developerCall = (LinearLayout) getActivity().findViewById(R.id.developer_call_ll);

        uploadItem.setOnClickListener(this);
        editItem.setOnClickListener(this);
        orderManagment.setOnClickListener(this);
        financeManagement.setOnClickListener(this);
        developerCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //toastManager.showSimpleToastShort("onClick executed...!!!");
        final int viewId = view.getId();
        if (viewId == R.id.upload_item_ll) {
            intent.putExtra(AdminContract.KEY, AdminContract.UPLOAD_ITEM);
            startActivity(intent);
        } else if (viewId == R.id.edit_item_ll) {
            intent.putExtra(AdminContract.KEY, AdminContract.UPLOAD_ITEM);
            startActivity(intent);
        } else if (viewId == R.id.order_management_ll) {
            intent.putExtra(AdminContract.KEY, AdminContract.UPLOAD_ITEM);
            startActivity(intent);
        } else if (viewId == R.id.finance_management_ll) {
            intent.putExtra(AdminContract.KEY, AdminContract.UPLOAD_ITEM);
            startActivity(intent);
        } else if (viewId == R.id.developer_call_ll) {
            intent.putExtra(AdminContract.KEY, AdminContract.UPLOAD_ITEM);
            startActivity(intent);
        }
    }
}



