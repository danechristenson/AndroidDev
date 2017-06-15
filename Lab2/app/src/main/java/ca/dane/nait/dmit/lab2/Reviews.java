package ca.dane.nait.dmit.lab2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import ca.dane.nait.dmit.lab2.model.Review;
import ca.dane.nait.dmit.lab2.model.ReviewContract;
import ca.dane.nait.dmit.lab2.model.ReviewDatabaseHelper;

public class Reviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        ListView reviewsListView = (ListView) findViewById(R.id.reviewsListView);
        List<Review> reviews = new ArrayList<>();
        Review review1 = new Review(1,"Best Food", "The best food in Edmonton", "Whyte Ave", "Meat", 5, "dane" );
        reviews.add(review1);
        ReviewAdapter adapter = new ReviewAdapter(this, reviews);
        reviewsListView.setAdapter(adapter);
        String[] projection = {
                ReviewContract.ReviewEntry.COLUMN_NAME_ID,
                ReviewContract.ReviewEntry.COLUMN_NAME_DESCRIPTION,
                ReviewContract.ReviewEntry.COLUMN_NAME_ALIAS,
                ReviewContract.ReviewEntry.COLUMN_NAME_ADDINFO,
                ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW,
                ReviewContract.ReviewEntry.COLUMN_NAME_CATEGORY,
                ReviewContract.ReviewEntry.COLUMN_NAME_RATING
        };

        ReviewDatabaseHelper dbHelper = new ReviewDatabaseHelper(this);
        Cursor cursor = dbHelper.findAllReviewsCursor();
        String[] fromColumns = {
                ReviewContract.ReviewEntry.COLUMN_NAME_DESCRIPTION,
                ReviewContract.ReviewEntry.COLUMN_NAME_ALIAS,
                ReviewContract.ReviewEntry.COLUMN_NAME_ADDINFO,
                ReviewContract.ReviewEntry.COLUMN_NAME_REVIEW,
                ReviewContract.ReviewEntry.COLUMN_NAME_CATEGORY,
                ReviewContract.ReviewEntry.COLUMN_NAME_RATING

        };

        int[] toViews = {R.id.reviewTextView, R.id.aliasTextView};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.review_item,
                cursor,
                fromColumns,
                toViews,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        reviewsListView.setAdapter(cursorAdapter);
    }
}
