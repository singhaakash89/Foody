package com.app.foody.cloudinarysync.server;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.app.foody.datastorage.accessor.MenuAccessor;
import com.app.foody.logger.Logger;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash Singh on 26-11-2016.
 */

public class StandardServerJobs implements ServerJobs {

    private static final String TAG = StandardServerJobs.class.getSimpleName();
    private static final String CLOUINARY_KEY = "Cloudinary_key : ";
    private static final String CLOUINARY_VALUE = "Cloudinary_value : ";

    @Override
    public String upToServer(String itemId, String filePath) {
        //for URL
        String imageURL = null;
        //for imagePath from DB
        String imagePath = null;
        //for storing URL coming from server
        Map<String, Object> cloudInaryMap = new HashMap<>();
        //for Initializing CloudInary Server Deatails
        Map<String, String> imageMap = new HashMap<String, String>();
        //Sending imagePath to CloudInary Server for URL
        File file = new File(imagePath);
        //storing Server details in MAP
        imageMap.put("cloud_name", ServerConfiguraton.CLOUD_NAME);
        imageMap.put("api_key", ServerConfiguraton.API_KEY);
        imageMap.put("api_secret", ServerConfiguraton.API_SECRET);
        Cloudinary cloudinary = new Cloudinary(imageMap);
        try {
            //cloudInaryMap = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            Map params = ObjectUtils.asMap("public_id", MenuAccessor.ITEM_ID);
            cloudInaryMap = cloudinary.uploader().upload(file, params);

            //print keys and values
            if (cloudinary != null) {
                for (Map.Entry<String, Object> entry : cloudInaryMap.entrySet()) {
                    Logger.putInDebugLog(TAG, CLOUINARY_KEY + entry.getKey(), CLOUINARY_VALUE + entry.getValue());
                }
                imageURL = (String) cloudInaryMap.get("url");
                Logger.putInDebugLog(TAG, "ImageURL", imageURL);
                Logger.putInDebugLog(TAG, "Cloudinary_upload_process", "successful");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageURL;
    }

    @Override
    public Bitmap downFromServer(String imageUrl) {
        Bitmap bitmap = null;
        try {
            //implement code for partial download and update like instagram
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
