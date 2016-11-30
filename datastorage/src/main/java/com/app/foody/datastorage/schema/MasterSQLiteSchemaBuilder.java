package com.app.foody.datastorage.schema;

import com.app.foody.datastorage.accessor.MenuAccessor;

import java.util.ArrayList;

/**
 * Created by Aakash Singh on 24-11-2016.
 */

public class MasterSQLiteSchemaBuilder {

    public ArrayList<String> getPrimaryDBCreateTableQueries() {
        ArrayList<String> queries = new ArrayList();
        queries.add(MenuSchemaBuilder.CREATE_TABLE);
        return queries;
    }

    public ArrayList<String> getPrimaryDBDropTableQueries() {
        ArrayList<String> queries = new ArrayList();
        queries.add(MenuSchemaBuilder.DROP_TABLE);
        return queries;
    }

    public ArrayList<String> getUpdateDBQueries(int oldVersion, int newVersion) {
        ArrayList<String> queries = null;
        if (oldVersion <= newVersion) {
            queries = new ArrayList();
            queries.add(MenuSchemaBuilder.DROP_TABLE);
            queries.add(MenuSchemaBuilder.CREATE_TABLE);
        }
        return queries;
    }

}
