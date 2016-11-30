package com.app.foody.oneui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.foody.oneui.fragment.StandardAdminFragment;
import com.app.foody.oneui.fragment.StandardMenuFragment;
import com.app.foody.oneui.fragment.StandardSuperUserFragment;
import com.app.foody.oneui.navDrawer.NavigationAdapter;
import com.app.foody.oneui.navDrawer.NavigationDrawerContract;
import com.app.foody.oneui.navDrawer.NavigationDrawerFragment;
import com.app.foody.oneui.toast.ToastManager;


/**
 * Created by Aakash Singh on 25-10-2016.
 */
public class BaseActivity extends AppCompatActivity implements NavigationDrawerContract {

    private static final String TAG = BaseActivity.class.getSimpleName();
    private static final int EXIT_TIME_OUT = 2000;
    private static Context mContext;
    private int backPressCount = 0;
    public static boolean menuFlag = false;
    private static final int TRANSITION_INTERVAL = 500;
    private static BaseActivity baseActivity;
    private static BaseActivityPresenter baseActivityPresenter;
    private Toolbar toolbar;
    private TextView fragmentNameForAppBar;
    private ImageView fragmentImageForAppBar;
    private LinearLayout fullLayout;
    private FrameLayout mainContentFrameLayout;
    private Intent intent;
    private ToastManager toastManager;
    private NavigationDrawerFragment navigationDrawerFragment;
    private TextView titleTextView;
    private ImageView iconImageView;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private ProgressBar progressBar;
    private NavigationAdapter.MyViewHolder myViewHolder;
    private StandardMenuFragment menuFragment;
    private StandardAdminFragment adminFragment;
    private StandardSuperUserFragment superUserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        ToastManager.createInstance(this);
        toastManager = ToastManager.getInstance();
        fragmentManager = getFragmentManager();
        menuFragment = new StandardMenuFragment();
        adminFragment = new StandardAdminFragment();
        superUserFragment = new StandardSuperUserFragment();
        baseActivityPresenter = new BaseActivityPresenter(this);
        setContentView(R.layout.activity_base);

        //---------ToolBar Implementation-------------
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //toolbar.setLogo(R.drawable.ic_logo);
        setSupportActionBar(toolbar);

        //ProgressBar
        progressBar = (ProgressBar) findViewById(R.id.progressBarID);
        progressBar.setVisibility(ProgressBar.GONE);

        //--------------Navigation Drawer Implementation------------------
        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, fragmentImageForAppBar);
        //----------------------------------------------------------------

        //Appbar Reformatting requirment when new fragment slides in
        fragmentNameForAppBar = (TextView) findViewById(R.id.fragmentNameForAppBar);
        fragmentImageForAppBar = (ImageView) findViewById(R.id.fragmentImageForAppBar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mContext = this;
        ToastManager.createInstance(this);
        toastManager = ToastManager.getInstance();
        fragmentManager = getFragmentManager();
        menuFragment = new StandardMenuFragment();
        adminFragment = new StandardAdminFragment();
        superUserFragment = new StandardSuperUserFragment();
        baseActivityPresenter = new BaseActivityPresenter(this);


        //---------ToolBar Implementation-------------
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //toolbar.setLogo(R.drawable.ic_logo);
        setSupportActionBar(toolbar);

        //ProgressBar
        progressBar = (ProgressBar) findViewById(R.id.progressBarID);
        progressBar.setVisibility(ProgressBar.GONE);

        //--------------Navigation Drawer Implementation------------------
        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, fragmentImageForAppBar);
        //----------------------------------------------------------------

        //Appbar Reformatting requirment when new fragment slides in
        fragmentNameForAppBar = (TextView) findViewById(R.id.fragmentNameForAppBar);
        fragmentImageForAppBar = (ImageView) findViewById(R.id.fragmentImageForAppBar);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.mContext = this;
        ToastManager.createInstance(this);
        toastManager = ToastManager.getInstance();
        fragmentManager = getFragmentManager();
        menuFragment = new StandardMenuFragment();
        adminFragment = new StandardAdminFragment();
        superUserFragment = new StandardSuperUserFragment();
        baseActivityPresenter = new BaseActivityPresenter(this);

        //---------ToolBar Implementation-------------
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //toolbar.setLogo(R.drawable.ic_logo);
        setSupportActionBar(toolbar);

        //ProgressBar
        progressBar = (ProgressBar) findViewById(R.id.progressBarID);
        progressBar.setVisibility(ProgressBar.GONE);

        //--------------Navigation Drawer Implementation------------------
        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, fragmentImageForAppBar);
        //----------------------------------------------------------------

        //Appbar Reformatting requirment when new fragment slides in
        fragmentNameForAppBar = (TextView) findViewById(R.id.fragmentNameForAppBar);
        fragmentImageForAppBar = (ImageView) findViewById(R.id.fragmentImageForAppBar);
    }

    @Override
    public void onBackPressed() {

        //Below code is for 2 second Pause for Exit Using HANDLER
        backPressCount++;
        if (backPressCount == 1) {
            toastManager.showSimpleToastShort("Press again to Exit");
        } else if (backPressCount == 2) {
            BaseActivity.this.finish();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressCount = 0;
            }
        }, EXIT_TIME_OUT);
    }


    public static BaseActivityPresenter getPresenterInstance() {
        return baseActivityPresenter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


    public static Context getContext() {
        return mContext;
    }


//''''''''''''''''''''''''''''''Uncomment if overriding setContentView()
//    /**
//     * @param layoutResID Provide id of layout you want to inflate
//     */
//
//    @Override
//    public void setContentView(final int layoutResID) {
//
//        // Your base layout goes here
//        fullLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
//
//        // Main content layout frame goes here
//        mainContentFrameLayout = (FrameLayout) fullLayout.findViewById(R.id.mainContentFrameLayout);
//
//        // Setting the content of layout your provided to the act_content frame
//        getLayoutInflater().inflate(layoutResID, mainContentFrameLayout, true);
//        super.setContentView(fullLayout);
//
//        //---------ToolBar Implementation-------------
//        toolbar = (Toolbar) findViewById(R.id.app_bar);
//        //toolbar.setLogo(R.drawable.ic_logo);
//        setSupportActionBar(toolbar);
//
//        //ProgressBar
//        progressBar = (ProgressBar) findViewById(R.id.progressBarID);
//        progressBar.setVisibility(ProgressBar.GONE);
//
//        //--------------Navigation Drawer Implementation------------------
//        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
//        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, fragmentImageForAppBar);
//        //----------------------------------------------------------------
//
//        //Appbar Reformatting requirment when new fragment slides in
//        fragmentNameForAppBar = (TextView) findViewById(R.id.fragmentNameForAppBar);
//        fragmentImageForAppBar = (ImageView) findViewById(R.id.fragmentImageForAppBar);
//    }

    @Override
    public void inflateBreakfastFragment() {
        menuFragment = new StandardMenuFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, menuFragment, "menuFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("Breakfast Menu");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }

    @Override
    public void inflateStarterFragment() {
        menuFragment = new StandardMenuFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, menuFragment, "menuFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("Starter Menu");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }

    @Override
    public void inflateMainCourseFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, menuFragment, "menuFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("MainCourse Menu");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }

    @Override
    public void inflateBeveragesFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, menuFragment, "menuFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("Beverages Menu");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }

    @Override
    public void inflateSweetsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, menuFragment, "menuFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("Sweets Menu");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }


    @Override
    public void inflateAdminModeFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, adminFragment, "adminFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("Admin Mode");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }

    @Override
    public void inflateSuperUserModeFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        //progressBar.setVisibility(ProgressBar.VISIBLE);
        //Delaying Fragment insertion so that drawer can close properly
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentTransaction.replace(R.id.mainContentFrameLayout, superUserFragment, "superUserFragment");
                fragmentTransaction.commitAllowingStateLoss();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }, TRANSITION_INTERVAL);

        fragmentNameForAppBar.setText("SuperUser Mode");
//        fragmentImageForAppBar.setImageResource(R.drawable.ic_add_group);
//        fragmentImageForAppBar.setOnClickListener(this);
    }
}
