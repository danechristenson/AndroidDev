package ca.dane.nait.dmit.lab2take2;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PickCategory extends AppCompatActivity {

    private String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_category);

        setBackgroundColor();

        ListView categoryListView = (ListView) findViewById(R.id.pick_category_ListView);
        try {
            new DownloadCategoryTask(PickCategory.this, categoryListView).execute("http://www.youcode.ca/Lab02Servlet?Service=categories");
        }catch (Exception e){
            Log.i("broken", e.getMessage());
        }



    }

    //region MENU
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
                //viewReviewsIntent.putExtra("radioValue",categoryRadioSelection );
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // write code to change the background color of view
        setBackgroundColor();
    }

    protected void setBackgroundColor(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String backgroundColorPref = prefs.getString("preference_background_color", "#FFFFFF");
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.pickCategoryContent);
        layout.setBackgroundColor(Color.parseColor(backgroundColorPref));
    }

    protected void setFontColor(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String fontColorPref = prefs.getString("preference_font_color", "#FFFFFF");
        TextView layout = (TextView) findViewById(R.id.view_review_AddInfoTextView);
        layout.setTextColor(Color.parseColor(fontColorPref));
    }
    //endregion


}
