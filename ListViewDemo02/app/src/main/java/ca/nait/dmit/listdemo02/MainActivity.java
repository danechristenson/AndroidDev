package ca.nait.dmit.listdemo02;

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

    final String[] provinces = new String[] {
            "Alberta (AB)",
            "British Columbia (BC)",
            "Manitoba (MB)",
            "New Brunswick (NB)",
            "Newfoundland and Labrador (NF)",
            "Northwest Territories NT",
            "Nova Scotia (NS)",
            "Nunavut (NU)",
            "Ontario (ON)",
            "Prince Edward Island (PE)",
            "Quebec (QC)",
            "Saskatchewan (SK)",
            "Yukon (YK)"
    };

    final String[] capitalCities = new String[] {
            "Edmonton",
            "Victoria",
            "Winnipeg",
            "Frederickton",
            "St. John",
            "Yellowknife",
            "Halifax",
            "Iqaluit",
            "Ottawa",
            "Chareletown",
            "Quebec",
            "Regina",
            "Whitehorse"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayAdapter<String> provinceList = new ArrayAdapter<String>(
//                this,
//                R.layout.province_item, R.id.province_name_textview,
//                provinces);
        ArrayAdapter<String> provinceList =  new ArrayAdapter<String>(
                this, -1, provinces) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater)
                        MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedView = inflater.inflate(R.layout.province_item, null);
                TextView provinceTextView = (TextView) inflatedView.findViewById(
                        R.id.province_name_textview);
                provinceTextView.setText( provinces[position] );
                TextView captialCityTextVIew = (TextView) inflatedView.findViewById(
                        R.id.capital_city_textview);
                captialCityTextVIew.setText( capitalCities[position] );
                return inflatedView;
            }
        };

        ListView provincesListView = (ListView) findViewById(R.id.listView);
        provincesListView.setAdapter(provinceList);
    }
}
