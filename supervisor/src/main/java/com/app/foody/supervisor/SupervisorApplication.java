package com.app.foody.supervisor;

import android.content.Context;

import com.app.foody.datastorage.PrimaryDBProvider;

/**
 * Created by Aakash Singh on 24-11-2016.
 */

/**
 * class for initializing all initial instances required throughout application
 */
public class SupervisorApplication {

    public SupervisorApplication(Context mContext) {
        PrimaryDBProvider.createInstance(mContext);
        PrimaryDBProvider.getInstance().getWritableDatabase();
    }
}
