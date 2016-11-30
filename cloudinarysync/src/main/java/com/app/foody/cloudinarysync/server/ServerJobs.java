package com.app.foody.cloudinarysync.server;

import android.graphics.Bitmap;

/**
 * Created by Aakash Singh on 26-11-2016.
 */

public interface ServerJobs {

    public String upToServer(String itemId, String filePath);

    public Bitmap downFromServer(String imageURL);
}
