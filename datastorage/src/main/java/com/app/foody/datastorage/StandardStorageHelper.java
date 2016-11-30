package com.app.foody.datastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Aakash Singh on 24-11-2016.
 */

public class StandardStorageHelper implements StorageHelper {

    private PrimaryDBProvider primaryDBProvider;

    public StandardStorageHelper(Context mContext) {
        if (mContext != null) {
            PrimaryDBProvider.createInstance(mContext);
            primaryDBProvider = PrimaryDBProvider.getInstance();
        }
    }

    @Override
    public long insertToDB(String table_name, ContentValues contentValues) {
        if (table_name == null || contentValues == null) {
            throw new SQLException("Table name OR ContentValues is null");
        } else {
            SQLiteDatabase db = this.primaryDBProvider.getWritableDatabase();
            long id = db.insert(table_name, null, contentValues);
            return id;
        }
    }

    @Override
    public long updateDB() {
        return 0;
    }

    @Override
    public Cursor queryFromDB(String tableName, String[] columns) {
        SQLiteDatabase db = this.primaryDBProvider.getWritableDatabase();
        Cursor cursor = db.query(tableName, columns, null, null, null, null, null);
        return cursor;
    }

    @Override
    public int deleteFromDB() {
        return 0;
    }
}
