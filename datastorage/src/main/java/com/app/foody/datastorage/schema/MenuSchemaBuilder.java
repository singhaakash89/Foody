package com.app.foody.datastorage.schema;

import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_CUISINE;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_ID;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_IMAGE;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_IS_AVAILABLE;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_NAME;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_PRICE;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_RATING;
import static com.app.foody.datastorage.accessor.MenuAccessor.ITEM_TYPE;

/**
 * Created by Aakash Singh on 24-11-2016.
 */

public class MenuSchemaBuilder {

    public static final String TABLE_NAME = "menu_item_table";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + " (" + ITEM_ID + " INTEGER PRIMARY KEY, " +
            ITEM_IMAGE + " BLOB, " +
            ITEM_NAME + " VARCHAR(255) NOT NULL UNIQUE, " +
            ITEM_TYPE + " VARCHAR(20) NOT NULL, " +
            ITEM_CUISINE + " VARCHAR(50), " +
            ITEM_PRICE + " VARCHAR(50), " +
            ITEM_RATING + " VARCHAR(10), " +
            ITEM_IS_AVAILABLE + " VARCHAR(20));";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }

    public static String getDropTable() {
        return DROP_TABLE;
    }
}
