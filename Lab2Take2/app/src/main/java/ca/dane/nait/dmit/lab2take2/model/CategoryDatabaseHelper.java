package ca.dane.nait.dmit.lab2take2.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super on 7/9/2017.
 */

public class CategoryDatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "categories.db";

    public CategoryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoryContract.SQL_CREATE_ENTRIES);
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(CategoryContract.CategoryEntry.COLUMN_NAME_CATEGORY, "movies");
        db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, contentValues1);
    }

    public void addCategory(Category currentCategory) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CategoryContract.CategoryEntry.COLUMN_NAME_CATEGORY, currentCategory.category);
        db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
    }

    public Cursor findAllCategoriesCursor() {
        String[] projection = {
                CategoryContract.CategoryEntry.COLUMN_NAME_ID,
                CategoryContract.CategoryEntry.COLUMN_NAME_CATEGORY

        };

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                CategoryContract.CategoryEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public List<Category> findAllCategories() {
        List<Category> reviews = new ArrayList<>();
        return reviews;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
