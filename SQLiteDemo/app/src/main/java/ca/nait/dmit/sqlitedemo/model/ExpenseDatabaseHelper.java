package ca.nait.dmit.sqlitedemo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swu on 6/5/2017.
 */

public class ExpenseDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "expenses.db";

    public ExpenseDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ExpenseContract.SQL_CREATE_ENTRIES );
        // add two expense entries
        ContentValues values1 = new ContentValues();
        values1.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                "Large Coffee");
        values1.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT,2.15f);
        values1.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE,"2017-06-05");
        db.insert(ExpenseContract.ExpenseEntry.TABLE_NAME,null,values1);

        ContentValues values2 = new ContentValues();
        values2.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                "Big Lunch");
        values2.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT,15.00f);
        values2.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE,"2017-06-02");
        db.insert(ExpenseContract.ExpenseEntry.TABLE_NAME,null,values2);
    }

    public void addExpense(Expense currentExpense){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION, currentExpense.description);
        values.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT, currentExpense.amount);
        values.put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE, currentExpense.date);
        db.insert(ExpenseContract.ExpenseEntry.TABLE_NAME, null, values);
    }

    public Cursor findAllExpensesCursor(){
        String[] projection = {
                ExpenseContract.ExpenseEntry.COLUMN_NAME_ID,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE
        };

        String sortBy = ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE + " DESC";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                ExpenseContract.ExpenseEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortBy
        );
        return cursor;
    }

    public List<Expense> findAllExpenses() {
        List<Expense> expenses = new ArrayList<>();

        return expenses;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
