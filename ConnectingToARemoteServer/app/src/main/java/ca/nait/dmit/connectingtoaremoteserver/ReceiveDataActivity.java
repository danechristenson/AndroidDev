package ca.nait.dmit.connectingtoaremoteserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ReceiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        final TextView dataTextView = (TextView) findViewById(R.id.dataTextView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.youcode.ca/JSONServlet";

        //Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Display the response
                dataTextView.setText("Response is: " + response);
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
