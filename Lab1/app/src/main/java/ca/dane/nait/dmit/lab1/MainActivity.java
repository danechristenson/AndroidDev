package ca.dane.nait.dmit.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
protected String categoryRadioSelection = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBackgroundColor();
    }

    protected void setBackgroundColor(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String backgroundColorPref = prefs.getString("preference_background_color", "#FFFFFF");
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.maincontent);
        layout.setBackgroundColor(Color.parseColor(backgroundColorPref));
    }

    public void setData(View view) {
        final TextView nomineeEditText = (TextView) findViewById(R.id.nomineeEditText);
        final TextView reviewEditText = (TextView) findViewById(R.id.reviewEditText);
        final RadioGroup categoryRadioButtonGroup = (RadioGroup) findViewById(R.id.categoryRadioGroup);
        categoryRadioButtonGroup.getCheckedRadioButtonId();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.youcode.ca/Lab01Servlet";

        if (!nomineeEditText.getText().toString().isEmpty() && !reviewEditText.getText().toString().isEmpty()) {

            //Request a string response from the provided URL
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Display the response
                    Toast.makeText(MainActivity.this, "Review sent!", Toast.LENGTH_LONG).show();
                    nomineeEditText.setText("");
                    reviewEditText.setText("");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    // return super.getParams();
                    Map<String, String> params = new HashMap<>();
                    params.put("REVIEW", reviewEditText.getText().toString());
                    params.put("REVIEWER", "Dane Christenson");
                    params.put("NOMINEE", nomineeEditText.getText().toString());
                    params.put("CATEGORY", categoryRadioSelection);
                    params.put("PASSWORD", "oscar275");
                    return params;


                }
            };

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        } else {
            Toast.makeText(this, "Woops looks like your missed one.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // write code to change the background color of view
        setBackgroundColor();
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
                Intent viewReviewsIntent = new Intent(this, ViewReviews.class);
                viewReviewsIntent.putExtra("radioValue",categoryRadioSelection );
                startActivity(viewReviewsIntent);
                return true;
            case R.id.preferences:
                Intent viewPreferencesIntent = new Intent(this, MainPreferenceActivity.class);
                startActivityForResult(viewPreferencesIntent, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
