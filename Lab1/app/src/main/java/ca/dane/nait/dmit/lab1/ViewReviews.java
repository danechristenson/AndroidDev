package ca.dane.nait.dmit.lab1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ViewReviews extends ListActivity {

    protected String categoryRadioSelection = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_reviews);

        final TextView dataTextView = (TextView) findViewById(R.id.reviewsTextView);

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
                ListAdapter responseAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_view_item, responseArray);
// STEP 4: Associate the Adapter with the ListActivity
                setListAdapter(responseAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dataTextView.setText("Error retrieving data from the server");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void categoryRadioClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.actorRadio:
                if(checked) {
                    categoryRadioSelection = "actor";
                    break;
                }
            case R.id.actressRadio:
                if(checked) {

                    categoryRadioSelection = "actress";
                    break;
                }
            case R.id.editingRadio:
                if(checked) {
                    categoryRadioSelection = "editing";
                    break;
                }
            case R.id.effectsRadio:
                if(checked) {
                    categoryRadioSelection = "effects";
                    break;
                }
            case R.id.filmRadio:
                if(checked) {
                    categoryRadioSelection = "film";
                    break;
                }
            default:
                break;
        }
    }
}
