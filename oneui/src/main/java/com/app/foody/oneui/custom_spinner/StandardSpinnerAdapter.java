package com.app.foody.oneui.custom_spinner;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.app.foody.oneui.BaseActivity;
import com.app.foody.oneui.R;
import java.util.List;

/**
 * Created by Aakash Singh on 29-11-2016.
 */

public class StandardSpinnerAdapter implements SpinnerAdapterContract {

    private ArrayAdapter<String> spinnerArrayAdapter;
    private Context mContext;

    public StandardSpinnerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public boolean setAdapter(Spinner spinner, List<String> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("Drop down array is null");
        } else {
            spinnerArrayAdapter = new ArrayAdapter<String>(mContext, R.layout.spinner_row_layout, arrayList);
            spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_drop_down_layout); // The drop down view
            spinner.setAdapter(spinnerArrayAdapter);
            return true;
        }

    }
}
