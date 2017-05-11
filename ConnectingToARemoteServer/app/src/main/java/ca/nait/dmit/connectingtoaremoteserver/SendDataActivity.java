package ca.nait.dmit.connectingtoaremoteserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class SendDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
    }

    public void viewJitters(View view){
        Intent recieveDataIntent = new Intent(this, ReceiveDataActivity.class);
        startActivity(recieveDataIntent);
    }

    public void setData(View view) {
        final TextView dataEditText = (TextView) findViewById(R.id.dataEditText);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.youcode.ca/Jitter";

        //Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Display the response
                Toast.makeText(SendDataActivity.this, response, Toast.LENGTH_LONG).show();
                dataEditText.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SendDataActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
            }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                   // return super.getParams();
                Map<String, String> params = new HashMap<>();
                params.put("DATA", dataEditText.toString());
                params.put("LOGIN_NAME", "Dane");
                return params;


            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
