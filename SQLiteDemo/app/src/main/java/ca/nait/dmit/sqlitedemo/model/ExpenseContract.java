package ca.nait.dmit.sqlitedemo.model;

import android.provider.BaseColumns;

/**
 * Created by swu on 6/5/2017.
 */

public final class ExpenseContract {

    private ExpenseContract() {}

    public static class ExpenseEntry implements BaseColumns {
        public static final String TABLE_NAME = "expenseTable";

        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        public static final String COLUMN_NAME_DATE = "date";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ExpenseEntry.TABLE_NAME + "(" +
            ExpenseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            ExpenseEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
            ExpenseEntry.COLUMN_NAME_AMOUNT + " REAL," +
            ExpenseEntry.COLUMN_NAME_DATE + " TEXT" +
            ")";
}
