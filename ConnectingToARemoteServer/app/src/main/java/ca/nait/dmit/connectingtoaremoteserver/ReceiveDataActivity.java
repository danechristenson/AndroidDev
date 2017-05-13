package ca.nait.dmit.connectingtoaremoteserver;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

//step one modify activity class to extends ListActivity
public class ReceiveDataActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_receive_data);
//
//        String[] hockeyTeams = new String[] {
//                "Anaheim Ducks",
//                "Nashville Predators",
//                "Ottawa Senators",
//                "Pittsburgh Penguins"
//        };
//        //STEP 3: create an adapter for the list data
//        ListAdapter teamAdapter = new ArrayAdapter<String>(this, R.layout.list_view_item, hockeyTeams);
//        setListAdapter(teamAdapter);


        final TextView dataTextView = (TextView) findViewById(R.id.dataTextView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.youcode.ca/JSONServlet";

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
}
