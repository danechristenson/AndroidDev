package ca.dane.nait.dmit.lab2.model;

import android.provider.BaseColumns;

/**
 * Created by dchristenson5 on 6/12/2017.
 */

public final class ReviewContract {
    private ReviewContract(){}

    public static class ReviewEntry implements BaseColumns {
        public static final String TABLE_NAME = "categoryTable";

        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_CATEGORY = "category";
//        public static final String COLUMN_NAME_DESCRIPTION = "description";
//        public static final String COLUMN_NAME_ADDINFO = "addInfo";
//        public static final String COLUMN_NAME_REVIEW = "review";
//        public static final String COLUMN_NAME_RATING = "rating";
//        public static final String COLUMN_NAME_ALIAS = "alias";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ReviewEntry.TABLE_NAME + "(" +
            ReviewEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            ReviewEntry.COLUMN_NAME_CATEGORY + " TEXT," + ")";
//            ReviewEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
//            ReviewEntry.COLUMN_NAME_ADDINFO + " TEXT," +
//            ReviewEntry.COLUMN_NAME_REVIEW + " TEXT," +
//            ReviewEntry.COLUMN_NAME_RATING + " TEXT," +
//            ReviewEntry.COLUMN_NAME_ALIAS + " TEXT" + ")";


}
