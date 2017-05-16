package ca.nait.dmit.listviewdemo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String[] provinces = {
            "Alberta",
            "British Columbia",
            "Manitoba",
            "New Brunswick",
            "Newfoundland",
            "North West Territories",
            "Nova Scotia",
            "Nunavut",
            "Ontario",
            "Prince Edward Island",
            "Saskatchewan",
            "Quebec",
            "Yukon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> provinceList = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                provinces);
        ListView provinceListView = (ListView) findViewById(R.id.listView);
        provinceListView.setAdapter(provinceList);
    }
}
