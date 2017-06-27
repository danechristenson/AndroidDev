package ca.dane.nait.dmit.lab2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import ca.dane.nait.dmit.lab2.model.Review;
import ca.dane.nait.dmit.lab2.model.ReviewContract;
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
        String[] fromColumns = {
                ReviewContract.ReviewEntry.COLUMN_NAME_CATEGORY,
        };

        int[] toViews = {
                R.id.addReviewCategorySpinner
        };
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.id.addReviewCategorySpinner, cursor, fromColumns, toViews, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER );

        mCategorySpinner.setAdapter(cursorAdapter);
    }

    public void onAddReview(View view) {
        String description = mDescriptionEditText.getText().toString();
        String category = mCategorySpinner.getAdapter().toString();
        String addInfo = mAddInfoEditText.getText().toString();
        String review = mReviewEditText.getText().toString();
        int rating = Integer.parseInt(mRatingEditText.getText().toString());


        ReviewDatabaseHelper dbHelper = new ReviewDatabaseHelper(this);
        Review currentReview = new Review(category, description, addInfo, review, rating);
        dbHelper.addReview(currentReview);

        mDescriptionEditText.setText("");
        mAddInfoEditText.setText("");
        mReviewEditText.setText("");
        mRatingEditText.setText("0");

    }
}
