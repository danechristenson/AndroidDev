package ca.dane.nait.dmit.lab2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import ca.dane.nait.dmit.lab2.model.ReviewDatabaseHelper;

public class AddReview extends AppCompatActivity {

    private Spinner mCategorySpinner; //food or movies
    private EditText mDescriptionEditText; //Name of the place/thing
    private EditText mAddInfoEditText; //address of restaurant
    private EditText mReviewEditText; // Actual Review
    private EditText mRatingEditText; //TODO:(dane) change this to a non number option


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        mDescriptionEditText = (EditText) findViewById(R.id.addReviewDescriptionEditText);
        mCategorySpinner = (Spinner) findViewById(R.id.addReviewCategorySpinner);
        mAddInfoEditText = (EditText) findViewById(R.id.addReviewAddInfoEditText);
        mReviewEditText = (EditText) findViewById(R.id.addReviewReviewEditText);
        mRatingEditText = (EditText) findViewById(R.id.addReviewRatingEditText);

        ReviewDatabaseHelper dbHelper = new ReviewDatabaseHelper(this);
        Cursor cursor = dbHelper.findAllReviewsCursor();

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.activity_add_review, cursor, )

    }

//    public void onAddExpense(View view) {
//        String description =mDescriptionEditText.getText().toString();
//        float amount = Float.parseFloat(mAmountEditText.getText().toString());
//        String dateString = String.format("$1-$2-%3", mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
//
//        ExpenseDatabaseHelper dbHelper = new ExpenseDatabaseHelper(this);
//        Expense currentExpense = new Expense(description, amount, dateString);
//        dbHelper.addExpense(currentExpense);
//
//        mDescriptionEditText.setText("");
//        mAmountEditText.setText("0.00");
//
//    }
}
