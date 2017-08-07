package ca.dane.dmit.homewifi.LocationModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super on 8/6/2017.
 */

public class LocationDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "location.db";

    public LocationDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LocationContract.SQL_CREATE_ENTRIES);
    }

    public void addLocation(Location currentLocation){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationContract.LocationEntry.COLUMN_NAME_DESCRIPTION, currentLocation.description);
        values.put( LocationContract.LocationEntry.COLUMN_NAME_LAT, currentLocation.lat);
        values.put( LocationContract.LocationEntry.COLUMN_NAME_LONG, currentLocation.lng);
        values.put(LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE, currentLocation.isActive);
        db.insert(LocationContract.LocationEntry.TABLE_NAME, null, values);
    }

    public List<Location> findAllLocations(){
        SQLiteDatabase db = getReadableDatabase();
        List<Location> locations = new ArrayList<Location>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LocationContract.LocationEntry.TABLE_NAME, null);

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Location currentLocation = new Location();

            currentLocation.setLat(cursor.getDouble(cursor.getColumnIndex(LocationContract.LocationEntry.COLUMN_NAME_LAT)));
            currentLocation.setLng(cursor.getDouble(cursor.getColumnIndex(LocationContract.LocationEntry.COLUMN_NAME_LONG)));
            currentLocation.setDescription(cursor.getString(cursor.getColumnIndex(LocationContract.LocationEntry.COLUMN_NAME_DESCRIPTION)));
            Boolean isActive = "1".equals(cursor.getString(cursor.getColumnIndex(LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE)));
            currentLocation.setActive(isActive);
            String test = cursor.getString(cursor.getColumnIndex(LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE));
            locations.add(currentLocation);
        }


        return locations;
    }

    public Cursor findAllLocationsCursor(){
        String[] projection = {
                LocationContract.LocationEntry.COLUMN_NAME_ID,
                LocationContract.LocationEntry.COLUMN_NAME_DESCRIPTION,
                LocationContract.LocationEntry.COLUMN_NAME_LONG,
                LocationContract.LocationEntry.COLUMN_NAME_LAT,
                LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE
        };

        String sortBy = LocationContract.LocationEntry.COLUMN_NAME_DESCRIPTION + " DESC";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                LocationContract.LocationEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortBy
        );
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
