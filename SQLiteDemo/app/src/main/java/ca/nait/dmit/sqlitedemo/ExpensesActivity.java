package ca.nait.dmit.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import ca.nait.dmit.sqlitedemo.model.Expense;
import ca.nait.dmit.sqlitedemo.model.ExpenseContract;
import ca.nait.dmit.sqlitedemo.model.ExpenseDatabaseHelper;

import static android.R.attr.id;

public class ExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        ListView expensesListView = (ListView) findViewById(R.id.expensesListView);
        List<Expense> expenses = new ArrayList<>();
        Expense expense1 = new Expense(1,"Large Coffe",2.15f,"2017-06-05");
        Expense expense2 = new Expense(2,"Lunch at Bytes",8.50f + 5.15f,"2017-06-02");
        expenses.add(expense1);
        expenses.add(expense2);
        ExpensesAdapter adapter = new ExpensesAdapter(this, expenses);
          expensesListView.setAdapter(adapter);
        String[] projection = {
                ExpenseContract.ExpenseEntry.COLUMN_NAME_ID,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE
        };

        ExpenseDatabaseHelper dbHelper = new ExpenseDatabaseHelper(this);
        Cursor cursor = dbHelper.findAllExpensesCursor();
        String[] fromColumns = {
                ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT,
                ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE
        };

        int[] toViews = {R.id.amounTextView, R.id.amounTextView, R.id.dateTextView};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.expense_item,
                cursor,
                fromColumns,
                toViews,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        expensesListView.setAdapter(cursorAdapter);
    }
}
