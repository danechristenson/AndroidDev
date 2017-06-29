package ca.dane.nait.dmit.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.dane.nait.dmit.lab2.model.Review;
import ca.dane.nait.dmit.lab2.model.ReviewDatabaseHelper;

public class AddCategory extends AppCompatActivity {

    private EditText addCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        addCategory  = (EditText) findViewById(R.id.addCategoryEditText);
    }

    public void addCategoryOnClick(View view){
        String category = addCategory.getText().toString();

        ReviewDatabaseHelper dbHelper = new ReviewDatabaseHelper(this);
        Reviews currentReview = new Reviews();
        dbHelper.addReview(category);

        addCategory.setText("");
    }
}
