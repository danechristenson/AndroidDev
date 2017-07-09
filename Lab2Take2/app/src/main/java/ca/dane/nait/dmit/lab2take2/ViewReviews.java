package ca.dane.nait.dmit.lab2take2;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class ViewReviews extends AppCompatActivity {

    protected String categoryRadioSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reviews);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            categoryRadioSelection = extras.getString("CATEGORY_SELECTED");
        }

        setBackgroundColor();
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://www.youcode.ca/Lab02Servlet?CATEGORY=" + categoryRadioSelection;

        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the response
                // dataTextView.setText("Response is: " + response);
                // STEP 3: create an adaptor for the list data
                String[] responseArray = response.split("\r\n");


                //ListAdapter responseAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_view_item, responseArray);
                ArrayList<Review> reviews = new ArrayList<>();
                for (int i = 0; i < responseArray.length; i+=6) {
                    try {
                        String description = responseArray[i+1];
                        String addInfo = responseArray[i+3];
                        String category = categoryRadioSelection;
                        int rating = Integer.parseInt(responseArray[i+4]);
                        String review = responseArray[i+2];
                        String alias = responseArray[i+5];

                        Review currentReview = new Review(category,description,addInfo,review,rating, alias);

                        reviews.add(currentReview);
                    } catch (Exception ex) {
                        Log.i("broken", "something broke");
                    }
                }


                ListView reviewsListView = (ListView) findViewById(R.id.view_reviews_ListView);
                ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), reviews);
                reviewsListView.setAdapter(adapter);

// STEP 4: Associate the Adapter with the ListActivity

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error calling the service", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    protected void setBackgroundColor(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String backgroundColorPref = prefs.getString("preference_background_color", "#FFFFFF");
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.viewReviewsContent);
        layout.setBackgroundColor(Color.parseColor(backgroundColorPref));
    }
}