package ca.dane.nait.dmit.lab2.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dchristenson5 on 6/12/2017.
 */

public class ReviewDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "reviews.db";

    public ReviewDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ReviewContract.SQL_CREATE_ENTRIES);
    }

    public void addReview(Review currentReview) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_ADDINFO, currentReview.addInfo);
//        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_ALIAS, currentReview.alias);
        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_CATEGORY, currentReview.category);
//        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_DESCRIPTION, currentReview.description);
//        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_RATING, currentReview.rating);
//        values.put(ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW, currentReview.review);
        db.insert(ReviewContract.ReviewEntry.TABLE_NAME, null, values);
    }

    public Cursor findAllReviewsCursor() {
        String[] projection = {
                ReviewContract.ReviewEntry.COLUMN_NAME_ID,
                ReviewContract.ReviewEntry.COLUMN_NAME_CATEGORY,
//                ReviewContract.ReviewEntry.COLUMN_NAME_ADDINFO,
//                ReviewContract.ReviewEntry.COLUMN_NAME_DESCRIPTION,
//                ReviewContract.ReviewEntry.COLUMN_NAME_RATING,
//                ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW,
//                ReviewContract.ReviewEntry.COLUMN_NAME_ALIAS
        };

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                ReviewContract.ReviewEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public List<Review> findAllReviews() {
        List<Review> reviews = new ArrayList<>();
        return reviews;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
