package ca.dane.nait.dmit.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.add_review:
                Intent viewReviewsIntent = new Intent(this, AddReview.class);
//                viewReviewsIntent.putExtra("radioValue",categoryRadioSelection );
                startActivity(viewReviewsIntent);
                return true;
            case R.id.preferences:
//                Intent viewPreferencesIntent = new Intent(this, MainPreferenceActivity.class);
//                startActivityForResult(viewPreferencesIntent, 0);
                return true;
            //case R.id.add_category:
            
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

//http://www.youcode.ca/Lab02Servlet?Category=