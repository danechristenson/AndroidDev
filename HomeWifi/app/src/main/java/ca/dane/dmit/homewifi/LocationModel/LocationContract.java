package ca.dane.dmit.homewifi.LocationModel;

import android.provider.BaseColumns;

/**
 * Created by super on 8/6/2017.
 */

public class LocationContract {
    private LocationContract () {}

    public static class LocationEntry implements BaseColumns{
        public static final String TABLE_NAME = "locationTable";

        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LONG = "long";
        public static final String COLUMN_NAME_ISACTIVE = "isActive";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + LocationEntry.TABLE_NAME + "(" +
            LocationEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            LocationEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
            LocationEntry.COLUMN_NAME_LAT + " TEXT, " +
            LocationEntry.COLUMN_NAME_LONG + " TEXT," +
            LocationEntry.COLUMN_NAME_ISACTIVE + " TEXT" +
            ")";

}


