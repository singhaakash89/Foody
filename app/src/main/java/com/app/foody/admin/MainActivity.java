package com.app.foody.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.foody.oneui.SplashActivity;
import com.app.foody.supervisor.SupervisorApplication;

/**
 * Created by Aakash Singh on 17-11-2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupervisorApplication supervisorApplication = new SupervisorApplication(this);
        startActivity(new Intent(this, SplashActivity.class));
        MainActivity.this.finish();
    }
}
