package ca.dane.nait.dmit.lab2take2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.dane.nait.dmit.lab2take2.model.Category;
import ca.dane.nait.dmit.lab2take2.model.CategoryDatabaseHelper;

public class AddCategory extends AppCompatActivity {

    private EditText mCategoryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        mCategoryEditText = (EditText) findViewById(R.id.addCategory_EditText);
    }

    public void addCategoryClick(View view){
        String category = mCategoryEditText.getText().toString();

        CategoryDatabaseHelper dbHelper = new CategoryDatabaseHelper(this);
        Category currentCategory =  new Category(category);
        dbHelper.addCategory(currentCategory);

        mCategoryEditText.setText("");
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
                Intent viewReviewsIntent = new Intent(this, PickCategory.class);
                startActivity(viewReviewsIntent);
                return true;
            case R.id.add_reviews:
                Intent addReviewsIntent = new Intent(this, PostReview.class);
                startActivity(addReviewsIntent);
                return true;

            case R.id.add_category:
                Intent addCategoryIntent = new Intent(this, AddCategory.class);
                startActivity(addCategoryIntent);
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
