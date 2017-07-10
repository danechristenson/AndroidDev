package ca.dane.nait.dmit.lab2take2.model;

import android.provider.BaseColumns;

/**
 * Created by super on 7/9/2017.
 */

public class CategoryContract {
    private CategoryContract(){}

    public static class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "categoryTable";

        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_CATEGORY = "category";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + CategoryEntry.TABLE_NAME + "(" +
            CategoryEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            CategoryEntry.COLUMN_NAME_CATEGORY + " TEXT" + ")";
}
