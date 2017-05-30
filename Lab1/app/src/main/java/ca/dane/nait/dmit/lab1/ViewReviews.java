package ca.dane.nait.dmit.lab1;

import android.app.ListActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class ViewReviews extends ListActivity {

    protected String categoryRadioSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_reviews);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            categoryRadioSelection = extras.getString("radioValue");
        }


        final ListView dataTextView = (ListView) findViewById(R.id.reviews_list_view);

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://www.youcode.ca/Lab01Servlet?CATEGORY=" + categoryRadioSelection;

        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the response
                // dataTextView.setText("Response is: " + response);
                // STEP 3: create an adaptor for the list data
                String[] responseArray = response.split("\r\n");
                ListAdapter responseAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_view_item, responseArray);
               final ArrayList<Review> reviews = new ArrayList<>();
                for (int i = 0; i < responseArray.length; i++) {
                    try {
                        Review currentReview = new Review();

                        currentReview.time = responseArray[i];
                        currentReview.reviewer = responseArray[i + 1];
                        currentReview.category = responseArray[i + 2];
                        currentReview.nominee = responseArray[i + 3];
                        currentReview.review = responseArray[i + 4];

                        reviews.add(currentReview);
                    } catch (Exception ex) {
                        Toast.makeText(ViewReviews.this, "something broke", Toast.LENGTH_SHORT).show();
                    }
                }

                ArrayAdapter<Review> reviewList =  new ArrayAdapter<Review>(getApplicationContext(), -1, reviews) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView,
                                        @NonNull ViewGroup parent) {
                        LayoutInflater inflater = (LayoutInflater)  ViewReviews.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View inflatedView = inflater.inflate(R.layout.list_view_item, null);
                        TextView timeTextView = (TextView) inflatedView.findViewById(R.id.time_textview);
                        timeTextView.setText(reviews.get(position).time);
                        TextView reviewerTextView = (TextView) inflatedView.findViewById(R.id.review_textview);
                        reviewerTextView.setText(reviews.get(position).reviewer);
                        TextView categoryTextView = (TextView) inflatedView.findViewById(R.id.category_textview);
                        categoryTextView.setText(reviews.get(position).time);
                        TextView nomineeTextView = (TextView) inflatedView.findViewById(R.id.nominee_textview);
                        nomineeTextView.setText(reviews.get(position).time);
                        TextView reviewTextView = (TextView) inflatedView.findViewById(R.id.review_textview);
                        reviewTextView.setText(reviews.get(position).time);

                        return inflatedView;
                    }
                };

                ListView reviewsListView = (ListView) findViewById(R.id.reviews_list_view);
                reviewsListView.setAdapter(reviewList); //TODO:(dane) Find out why this is returning NULL
// STEP 4: Associate the Adapter with the ListActivity
                setListAdapter(responseAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //dataTextView.setText("Error retrieving data from the server");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}