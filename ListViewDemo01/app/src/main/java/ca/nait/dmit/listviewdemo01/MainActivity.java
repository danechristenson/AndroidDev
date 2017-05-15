package ca.nait.dmit.listviewdemo01;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

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
//        setContentView(R.layout.activity_main);

    ListAdapter provinceList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, provinces);
    setListAdapter(provinceList);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        Toast.makeText(this, provinces[position], Toast.LENGTH_SHORT).show();
    }
}
