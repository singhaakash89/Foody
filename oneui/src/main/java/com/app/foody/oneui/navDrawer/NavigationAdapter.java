package com.app.foody.oneui.navDrawer;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.foody.oneui.BaseActivity;
import com.app.foody.oneui.R;
import com.app.foody.oneui.fragment.StandardAdminFragment;
import com.app.foody.oneui.toast.ToastManager;

import java.util.Collections;
import java.util.List;

/**
 * Created by Aakash Singh on 21-08-2015.
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private DrawerLayout drawerLayout;
    private List<NavigationRowData> navigationRowDataList = Collections.emptyList();
    private RecyclerView drawerList;
    private Intent intent;
    private static DrawerLayout mDrawerLayout;
    private MyViewHolder myViewHolder;
    private ToastManager toastManager;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private StandardAdminFragment standardAdminRolesFragment;

    public static void reIntializeDrawerLayout(DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
    }

    public NavigationAdapter(Context context, List<NavigationRowData> navigationRowDataList, RecyclerView drawerList, DrawerLayout drawerLayout) {
        Log.d("CHECK :: ", "INSIDE (NavigationAdapter CONSTRUCTOR)");
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.navigationRowDataList = navigationRowDataList;
        this.drawerList = drawerList;
        this.drawerLayout = drawerLayout;
    }

    @SuppressLint("LongLogTag")
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("CHECK :: ", "INSIDE (onCreateViewHolder)");
        View view = inflater.inflate(R.layout.nav_custom_row, parent, false);
        myViewHolder = new MyViewHolder(context, view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        Log.e("CHECK :: ", "INSIDE (onBindViewHolder)");
        //fecthing data from ArrayList into Bean of Text/Image type
        NavigationRowData navigationRowData = navigationRowDataList.get(position);
        //setting data from Bean into Holder
        myViewHolder.titleTextView.setText(navigationRowData.getTitleId());
        myViewHolder.iconImageView.setImageResource(navigationRowData.getIconId());
    }

    @Override
    public int getItemCount() {
        Log.e("CHECK :: ", "INSIDE (getItemCount)");
        return navigationRowDataList.size();
    }

    public MyViewHolder getMyViewHolder() {
        return myViewHolder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, NavigationDrawerContract {
        TextView titleTextView;
        ImageView iconImageView;

        public MyViewHolder(Context context, View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.navCustomRowTextView);
            iconImageView = (ImageView) itemView.findViewById(R.id.navCustomRowImageView);
            iconImageView.setOnClickListener(this);
            titleTextView.setOnClickListener(this);
            toastManager = ToastManager.getInstance();
        }

        @Override
        public void onClick(View v) {
            String onPressed = titleTextView.getText().toString();
            toastManager.showSimpleToastShort(onPressed + " is selected");
            switch (onPressed) {
                case DrawerMenuItem.BREAKFAST:
                    inflateBreakfastFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                case DrawerMenuItem.STARTER:
                    inflateStarterFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                case DrawerMenuItem.MAIN_COURSE:
                    inflateMainCourseFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                case DrawerMenuItem.BEVERAGES:
                    inflateBeveragesFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                case DrawerMenuItem.SWEETS:
                    inflateSweetsFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                case DrawerMenuItem.ADMIN_MODE:
                    inflateAdminModeFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                case DrawerMenuItem.SUPER_USER_MODE:
                    inflateSuperUserModeFragment();
                    mDrawerLayout.closeDrawers();
                    break;

                default:
                    break;
            }
        }

        @Override
        public void inflateBreakfastFragment() {
            BaseActivity.getPresenterInstance().inflateBreakfastFragment();
        }

        @Override
        public void inflateStarterFragment() {
            BaseActivity.getPresenterInstance().inflateStarterFragment();
        }

        @Override
        public void inflateMainCourseFragment() {
            BaseActivity.getPresenterInstance().inflateMainCourseFragment();
        }

        @Override
        public void inflateSweetsFragment() {
            BaseActivity.getPresenterInstance().inflateSweetsFragment();
        }

        @Override
        public void inflateBeveragesFragment() {
            BaseActivity.getPresenterInstance().inflateBeveragesFragment();
        }

        @Override
        public void inflateAdminModeFragment() {
            BaseActivity.getPresenterInstance().inflateAdminModeFragment();
        }

        @Override
        public void inflateSuperUserModeFragment() {
            BaseActivity.getPresenterInstance().inflateSuperUserModeFragment();
        }
    }
}
