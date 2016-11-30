package com.app.foody.menu.dataStorage;

import android.content.ContentValues;
import android.database.Cursor;

import com.app.foody.datastorage.StorageHelper;

/**
 * Created by Aakash Singh on 24-11-2016.
 */

public class MenuDataProvider {

    private StorageHelper storageHelper;

    public MenuDataProvider(StorageHelper storageHelper) {
        this.storageHelper = storageHelper;
    }

    public long write(String tableName, ContentValues cv) {
        return this.storageHelper.insertToDB(tableName, cv);
    }

    public Cursor read(String tableName, String [] projection)
    {
        Cursor cursor = this.storageHelper.queryFromDB(tableName, projection);
        return cursor;
    }
}
