package com.app.foody.oneui.activities.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.foody.oneui.R;
import com.app.foody.oneui.custom_spinner.StandardSpinnerAdapter;
import com.app.foody.oneui.navDrawer.NavigationDrawerFragment;
import com.app.foody.oneui.toast.ToastManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash Singh on 29-11-2016.
 */

public class AdminBaseActivity extends AppCompatActivity implements AdminContract, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = AdminBaseActivity.class.getSimpleName();
    private Toolbar toolbar;
    private TextView fragmentNameForAppBar;
    private ImageView fragmentImageForAppBar;
    private LinearLayout fullLayout;
    private FrameLayout mainContentFrameLayout;
    private ToastManager toastManager;
    private NavigationDrawerFragment navigationDrawerFragment;
    private TextView titleTextView;
    private ImageView iconImageView;
    private Spinner spinnerType;
    private Spinner spinnerCuisine;
    private Spinner spinnerRating;
    private Spinner spinnerAvailable;
    private static StandardAdminPresenter standardAdminPresenter;
    private StandardSpinnerAdapter standardSpinnerAdapter;
    private String[] array;
    private List<String> arrayList;
    private SpinnerModel spinnerModel;
    private Intent intent;
    private final int SELECT_PHOTO = 100;
    private ProgressDialog progressDialog;

    private TextView item_Image_tv;
    private TextView item_id_tv;
    private TextView item_name_tv;
    private TextView item_type_tv;
    private TextView item_rating_tv;
    private TextView item_price_tv;
    private TextView item_cuisine_tv;
    private TextView item_avaiability_tv;

    private ImageView item_ImgView;
    private EditText item_id_et;
    private EditText item_name_et;
    private Spinner item_type_spinner;
    private Spinner item_rating_spinner;
    private EditText item_price_et;
    private Spinner item_cuisine_spinner;
    private Spinner item_avaiability_spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        standardAdminPresenter = new StandardAdminPresenter(this);
        standardSpinnerAdapter = new StandardSpinnerAdapter(this);
        toastManager = ToastManager.getInstance();
        progressDialog = new ProgressDialog(this);
        inflateView(getIntent().getStringExtra(AdminContract.KEY));
    }

    @Override
    protected void onResume() {
        super.onResume();
        standardAdminPresenter = new StandardAdminPresenter(this);
        standardSpinnerAdapter = new StandardSpinnerAdapter(this);
        toastManager = ToastManager.getInstance();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        standardAdminPresenter = new StandardAdminPresenter(this);
        standardSpinnerAdapter = new StandardSpinnerAdapter(this);
        toastManager = ToastManager.getInstance();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdminBaseActivity.this.finish();
    }

    private void inflateView(String intentValue) {
        if (intentValue.equals(AdminContract.UPLOAD_ITEM)) {
            uploadItem(R.layout.layout_admin_upload_item);
        } else if (true) {
            //edit item
            //order
            //finance
        }
    }

    public static StandardAdminPresenter getPresenterInstance() {
        return standardAdminPresenter;
    }

    /**
     * @param layoutResID Provide id of layout you want to inflate
     */

    @Override
    public void setContentView(final int layoutResID) {

        // Your base layout goes here
        fullLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_admin_base, null);

        // Main content layout frame goes here
        mainContentFrameLayout = (FrameLayout) fullLayout.findViewById(R.id.mainContentFrameLayout);

        // Setting the content of layout your provided to the act_content frame
        getLayoutInflater().inflate(layoutResID, mainContentFrameLayout, true);
        super.setContentView(fullLayout);

        //---------ToolBar Implementation-------------
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //----HomeButtonEnabled-------------------------
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //---------------------------------------------

        //Appbar Reformatting requirment when new fragment slides in
        fragmentNameForAppBar = (TextView) findViewById(R.id.fragmentNameForAppBar);
        fragmentImageForAppBar = (ImageView) findViewById(R.id.fragmentImageForAppBar);
    }


    @Override
    public boolean uploadItem(int resId) {
        setContentView(resId);
        fragmentNameForAppBar.setText(getResources().getString(R.string.upload_item));
        //refering all textviews
//        item_ImgView = (ImageView) findViewById(R.id.item_ImgView);
//        item_Image_tv = (TextView) findViewById(R.id.item_Image_tv);
//        item_id_tv = (TextView) findViewById(R.id.item_id_tv);
//        item_name_tv = (TextView) findViewById(R.id.item_name_tv);
//        item_type_tv = (TextView) findViewById(R.id.item_type_tv);
//        item_rating_tv = (TextView) findViewById(R.id.item_rating_tv);
//        item_price_tv = (TextView) findViewById(R.id.item_price_tv);
//        item_cuisine_tv = (TextView) findViewById(R.id.item_cuisine_tv);
//        item_avaiability_tv = (TextView) findViewById(R.id.item_avaiability_tv);
//
//        //refering all edittext
//        item_id_et = (EditText) findViewById(R.id.item_id_et);
//        item_name_et = (EditText) findViewById(R.id.item_name_et);
//        item_type_spinner = (Spinner) findViewById(R.id.item_type_spinner);
//        item_rating_spinner = (Spinner) findViewById(R.id.item_rating_spinner);
//        item_price_et = (EditText) findViewById(R.id.item_price_et);
//        item_cuisine_spinner = (Spinner) findViewById(R.id.item_cuisine_spinner);
//        item_avaiability_spinner = (Spinner) findViewById(R.id.item_avaiability_spinner);
//
//        item_ImgView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                // 2. pick image only
//                intent.setType("image/*");
//                // 3. start activity
//                startActivityForResult(intent, SELECT_PHOTO);
//            }
//        });
//
//        item_id_et.setOnFocusChangeListener(this);
//        item_name_et.setOnFocusChangeListener(this);
//        item_type_spinner.setOnItemSelectedListener(this);
//        item_rating_spinner.setOnItemSelectedListener(this);
//        item_price_et.setOnFocusChangeListener(this);
//        item_cuisine_spinner.setOnItemSelectedListener(this);
//        item_avaiability_spinner.setOnItemSelectedListener(this);
//
//        //Clearing Edit Text Focus when activity starts
//        item_id_et.clearFocus();
//        item_name_et.clearFocus();
//        item_price_et.clearFocus();
//
//        spinnerModel = new SpinnerModel();
//        for (int i = 0; i < spinnerModel.getId().length; i++) {
//            arrayList = Arrays.asList(getResources().getStringArray(spinnerModel.getId(i)));
//            standardSpinnerAdapter.setAdapter(spinnerModel.getSpinner(i), arrayList);
//        }
        return true;
    }

    @Override
    public boolean editItem(int resId) {
        setContentView(resId);
        fragmentNameForAppBar.setText(getResources().getString(R.string.edit_item));
        return false;
    }

    @Override
    public boolean orderManagement(int resId) {
        setContentView(resId);
        fragmentNameForAppBar.setText(getResources().getString(R.string.order_management));
        return false;
    }

    @Override
    public boolean financeManagement(int resId) {
        setContentView(resId);
        fragmentNameForAppBar.setText(getResources().getString(R.string.finance_management));
        return false;
    }

    @Override
    public boolean developerCall(int resId) {
        setContentView(resId);
        fragmentNameForAppBar.setText(getResources().getString(R.string.developer_call));
        return false;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        EditText et = (EditText) view.findViewById(view.getId());
        if (hasFocus && view.getId() == R.id.item_id_et) {
            item_id_tv.setVisibility(View.VISIBLE);
            item_id_et.setHint("");
        } else if (hasFocus && view.getId() == R.id.item_name_et) {
            item_name_tv.setVisibility(View.VISIBLE);
            item_name_et.setHint("");
        } else if (hasFocus && view.getId() == R.id.item_price_et) {
            item_price_tv.setVisibility(View.VISIBLE);
            item_price_et.setHint("");
        } else if (!hasFocus && view.getId() == R.id.item_id_et && et.getText().toString().isEmpty()) {
            item_id_tv.setVisibility(View.GONE);
            item_id_et.setHint(R.string.item_id_et);
        } else if (!hasFocus && view.getId() == R.id.item_name_et && et.getText().toString().isEmpty()) {
            item_name_tv.setVisibility(View.GONE);
            item_name_et.setHint(R.string.item_name_et);
        } else if (!hasFocus && view.getId() == R.id.item_price_et && et.getText().toString().isEmpty()) {
            item_price_tv.setVisibility(View.GONE);
            item_price_et.setHint(R.string.item_price_et);
        }
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Spinner spinner = (Spinner) parent;
//        if (spinner.getId() == R.id.item_type_spinner) {
//            if (!spinner.getSelectedItem().toString().equals(R.string.item_type_et))
//                item_type_tv.setVisibility(View.GONE);
//            else
//                item_type_tv.setVisibility(View.VISIBLE);
//        } else if (spinner.getId() == R.id.item_cuisine_spinner) {
//            if (!spinner.getSelectedItem().toString().equals(R.string.item_cuisine_et))
//                item_cuisine_tv.setVisibility(View.GONE);
//            else
//                item_cuisine_tv.setVisibility(View.VISIBLE);
//        } else if (spinner.getId() == R.id.item_rating_spinner) {
//            if (!spinner.getSelectedItem().toString().equals(R.string.item_rating_et))
//                item_rating_tv.setVisibility(View.GONE);
//            else
//                item_rating_tv.setVisibility(View.VISIBLE);
//        } else if (spinner.getId() == R.id.item_avaiability_spinner) {
//            if (!spinner.getSelectedItem().toString().equals(R.string.item_avaiability_et))
//                item_avaiability_tv.setVisibility(View.GONE);
//            else
//                item_avaiability_tv.setVisibility(View.VISIBLE);
//        }
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.item_type_spinner) {
            if (spinner.getSelectedItem().toString().contains("Item"))
                item_type_tv.setVisibility(TextView.GONE);
            else
                item_type_tv.setVisibility(TextView.VISIBLE);

        }

        if (spinner.getId() == R.id.item_cuisine_spinner) {
            if (spinner.getSelectedItem().toString().contains("Item"))
                item_cuisine_tv.setVisibility(TextView.GONE);
            else
                item_cuisine_tv.setVisibility(TextView.VISIBLE);

        }

        if (spinner.getId() == R.id.item_rating_spinner) {
            if (spinner.getSelectedItem().toString().contains("Item"))
                item_rating_tv.setVisibility(TextView.GONE);
            else
                item_rating_tv.setVisibility(TextView.VISIBLE);
        }

        if (spinner.getId() == R.id.item_avaiability_spinner) {
            if (spinner.getSelectedItem().toString().contains("Item"))
                item_avaiability_tv.setVisibility(TextView.GONE);
            else
                item_avaiability_tv.setVisibility(TextView.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class SpinnerModel {
        private int[] id = {R.array.item_type_spinner_entries, R.array.item_cuisine_spinner_entries, R.array.item_rating_spinner_entries, R.array.item_availability_spinner_entries};
        private Spinner[] spinner = {item_type_spinner, item_cuisine_spinner, item_rating_spinner, item_avaiability_spinner};

        public int getId(int index) {
            return id[index];
        }

        public Spinner getSpinner(int index) {
            return spinner[index];
        }

        public int[] getId() {
            return id;
        }
    }
}
