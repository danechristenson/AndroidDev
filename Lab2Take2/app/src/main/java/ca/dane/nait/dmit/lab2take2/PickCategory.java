package ca.dane.nait.dmit.lab2take2;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PickCategory extends AppCompatActivity {

    private String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_category);

        ListView categoryListView = (ListView) findViewById(R.id.pick_category_ListView);
        new DownloadCategoryTask(this, categoryListView).execute("http://www.youcode.ca/Lab02Servlet?Service=categories");



      // categoryListView.setItemOnClick
    }


}
