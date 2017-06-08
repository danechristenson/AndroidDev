package ca.nait.dmit.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import ca.nait.dmit.sqlitedemo.model.Expense;
import ca.nait.dmit.sqlitedemo.model.ExpenseDatabaseHelper;

public class AddExpense extends AppCompatActivity {

    private EditText mDescriptionEditText;
    private EditText mAmountEditText;
    private DatePicker mDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        mDescriptionEditText = (EditText) findViewById(R.id.addExpense_descriptionEditText);
        mAmountEditText = (EditText) findViewById(R.id.addExpense_amountEditText);
        mDatePicker = (DatePicker) findViewById(R.id.addExpense_datePicker);
    }

    public void onAddExpense(View view) {
        String description =mDescriptionEditText.getText().toString();
        float amount = Float.parseFloat(mAmountEditText.getText().toString());
        String dateString = String.format("$1-$2-%3", mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());

        ExpenseDatabaseHelper dbHelper = new ExpenseDatabaseHelper(this);
        Expense currentExpense = new Expense(description, amount, dateString);
        dbHelper.addExpense(currentExpense);

        mDescriptionEditText.setText("");
        mAmountEditText.setText("0.00");
    }
}
