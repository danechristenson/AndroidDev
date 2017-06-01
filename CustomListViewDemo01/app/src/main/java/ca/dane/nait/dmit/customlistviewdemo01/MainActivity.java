package ca.dane.nait.dmit.customlistviewdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.youcode.ca/JSONServlet";
        // Request a string response from the provided url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){

                        String[] responseArray = response.split("\r\n");
                        ArrayList<Jitter> jitters = new ArrayList<>();
                        for(int i = 0; i<responseArray.length; i++){
                            String currentLineText = responseArray[i];
                            String sender = currentLineText.substring(currentLineText.indexOf(" from ") + 5, currentLineText.indexOf("***"));
                            String date = currentLineText.split(" from ")[0];
                            String text = currentLineText.substring(currentLineText.indexOf("***") + 4, currentLineText.length());
                            Jitter currentJitter = new Jitter();
                            currentJitter.sender = sender;
                            currentJitter.date = date;
                            currentJitter.text = text;
                            //add to list
                            jitters.add(currentJitter);
                        }
                        ListView jittersListView = (ListView) findViewById(R.id.jitterListView);
                        ListViewAdapter adapter = new ListViewAdapter( getApplicationContext(), jitters);
                        jittersListView.setAdapter(adapter);
                    }
                },
        new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(),"Error calling the service", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }
}
