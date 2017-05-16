package ca.nait.dmit.listviewdemo02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

    final String[] capitalCities = {
            "Edmonton",
            "Victoria",
            "Winnipeg",
            "Fredericton",
            "St. John",
            "Yellow Knife",
            "Halifax",
            "Iqaluit",
            "Ottawa",
            "Charlottetown",
            "Regina",
            "Quebec",
            "Whitehorse"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayAdapter<String> provinceList = new ArrayAdapter<String>(
//                this,
//                R.layout.province_item,
//                R.id.provinceNameTextView,
//                provinces);
        ArrayAdapter<String> provinceList = new ArrayAdapter<String>(
                this,
                -1, //no layout page
                provinces) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //return super.getView(position, convertView, parent);
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedView = inflater.inflate(R.layout.province_item, null);

                TextView provinceTextView = (TextView) inflatedView.findViewById(R.id.provinceNameTextView);
                provinceTextView.setText(provinces[position]);
                TextView capitalCityTextView = (TextView) inflatedView.findViewById(R.id.capitalCityTextView);
                capitalCityTextView.setText(capitalCities[position]);

                return inflatedView;
            }
        };

        ListView provinceListView = (ListView) findViewById(R.id.listView);
        provinceListView.setAdapter(provinceList);
    }
}
