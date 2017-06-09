package ca.dane.nait.dmit.lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class ViewReviews extends AppCompatActivity {

    protected String categoryRadioSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reviews);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            categoryRadioSelection = extras.getString("radioValue");
        }


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


                //ListAdapter responseAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_view_item, responseArray);
               ArrayList<Review> reviews = new ArrayList<>();
                for (int i = 0; i < responseArray.length; i+=5) {
                    try {
                        String time = responseArray[i];
                        String reviewer = responseArray[i+1];
                        String category = responseArray[i+2];
                        String nominee = responseArray[i+3];
                        String review = responseArray[i+4];

                        Review currentReview = new Review();
                        currentReview.time = time; //responseArray[i];
                        currentReview.reviewer = reviewer;//responseArray[i + 1];
                        currentReview.category = category;//responseArray[i + 2];
                        currentReview.nominee = nominee;//responseArray[i + 3];
                        currentReview.review = review;//responseArray[i + 4];

                        reviews.add(currentReview);
                    } catch (Exception ex) {
                        Log.i("broken", "something broke");
                    }
                }

                ListView reviewsListView = (ListView) findViewById(R.id.reviews_list_view); //FIXME(dane): why does this come back null?
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
}