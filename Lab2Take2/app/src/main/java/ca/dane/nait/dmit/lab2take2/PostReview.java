package ca.dane.nait.dmit.lab2take2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import ca.dane.nait.dmit.lab2take2.model.Category;
import ca.dane.nait.dmit.lab2take2.model.CategoryContract;
import ca.dane.nait.dmit.lab2take2.model.CategoryDatabaseHelper;

public class PostReview extends AppCompatActivity {
    private Spinner mCategorySpinner; //food or movies
    private EditText mDescriptionEditText; //Name of the place/thing
    private EditText mAddInfoEditText; //address of restaurant
    private EditText mReviewEditText; // Actual Review
    private EditText mRatingEditText; //TODO:(dane) change this to a non number option


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);

        mDescriptionEditText = (EditText) findViewById(R.id.addReviewDescriptionEditText);
        mCategorySpinner = (Spinner) findViewById(R.id.addReviewCategorySpinner);
        mAddInfoEditText = (EditText) findViewById(R.id.addReviewAddInfoEditText);
        mReviewEditText = (EditText) findViewById(R.id.addReviewReviewEditText);
        mRatingEditText = (EditText) findViewById(R.id.addReviewRatingEditText);

        CategoryDatabaseHelper dbHelper = new CategoryDatabaseHelper(this);
        Cursor cursor = dbHelper.findAllCategoriesCursor();

        String[] fromColumns = {
                CategoryContract.CategoryEntry.COLUMN_NAME_CATEGORY
        };

        int[] toViews = {
                R.id.category_textView
        };
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.category_spinner,
                cursor,
                fromColumns,
                toViews,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER );

        mCategorySpinner.setAdapter(cursorAdapter);
    }

    public void onAddReview(View view) {
        final String description = mDescriptionEditText.getText().toString();
        final String category = mCategorySpinner.getAdapter().toString();
        final String addInfo = mAddInfoEditText.getText().toString();
        final String review = mReviewEditText.getText().toString();
        final String rating = mRatingEditText.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.youcode.ca/Lab02Servlet";
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final String alias = prefs.getString("preference_name", "Dane Christenson");

        int ratingInt = Integer.parseInt(rating);

        if(!description.isEmpty()  && !addInfo.isEmpty() && !review.isEmpty() && ratingInt > 0 && ratingInt <= 5) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(PostReview.this, "Review sent!", Toast.LENGTH_LONG).show();
                    mDescriptionEditText.setText("");
                    mAddInfoEditText.setText("");
                    mReviewEditText.setText("");
                    mRatingEditText.setText("0");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(PostReview.this, "Fail", Toast.LENGTH_SHORT).show();
                }

            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("CATEGORY", category);
                    params.put("DESCRIPTION", description);
                    params.put("ADDINFO", addInfo);
                    params.put("REVIEW", review);
                    params.put("RATING", rating);
                    params.put("ALIAS", alias);

                    return params;
                }
            };
            queue.add(stringRequest);
        } else {
            Toast.makeText(this, "Woops, looks like you missed one", Toast.LENGTH_SHORT).show();
        }

    }

    //region MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Create an instance of the menu inflater
        MenuInflater inflater = getMenuInflater();
        // inflate the menu
        inflater.inflate(R.menu.main_menu, menu);
        // return true if menu inflated ok
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.view_reviews:
                Intent viewReviewsIntent = new Intent(this, PickCategory.class);
                startActivity(viewReviewsIntent);
                return true;
            case R.id.add_reviews:
                Intent addReviewsIntent = new Intent(this, PostReview.class);
                startActivity(addReviewsIntent);
                return true;

            case R.id.add_category:
                Intent addCategoryIntent = new Intent(this, AddCategory.class);
                startActivity(addCategoryIntent);
                return true;
            case R.id.preferences:
                Intent viewPreferencesIntent = new Intent(this, MainPreferenceActivity.class);
                startActivityForResult(viewPreferencesIntent, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // write code to change the background color of view
        setBackgroundColor();
    }

    protected void setBackgroundColor(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String backgroundColorPref = prefs.getString("preference_background_color", "#FFFFFF");
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.pickCategoryContent);
        layout.setBackgroundColor(Color.parseColor(backgroundColorPref));
    }

    protected void setFontColor(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String fontColorPref = prefs.getString("preference_font_color", "#FFFFFF");
        TextView layout = (TextView) findViewById(R.id.view_review_AddInfoTextView);
        layout.setTextColor(Color.parseColor(fontColorPref));
    }
    //endregion


}
