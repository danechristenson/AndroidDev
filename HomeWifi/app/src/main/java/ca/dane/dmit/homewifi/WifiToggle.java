package ca.dane.dmit.homewifi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import ca.dane.dmit.homewifi.LocationModel.LocationAdapter;
import ca.dane.dmit.homewifi.LocationModel.LocationContract;
import ca.dane.dmit.homewifi.LocationModel.LocationDatabaseHelper;


public class WifiToggle extends AppCompatActivity {

    Button toggleButton;
    TextView wifiStateTextView;
    LocationManager locationManager;
    LocationListener locationListener;
    WifiManager wifiManager;

    double currentLat, currentLong, homeLat, homeLong;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }
//add new locations
    public void addLocationView(View view){
        Intent addLocationIntent = new Intent(this, AddLocation.class);
        startActivity(addLocationIntent);
    }

    public void deleteLocation(){
        //call db and delete entry
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_toggle);

        toggleButton = (Button) findViewById(R.id.wifiToggleButton);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        ListView locationListView = (ListView) findViewById(R.id.locationListView);

        List<ca.dane.dmit.homewifi.LocationModel.Location> locations = new ArrayList<>();
        LocationAdapter adapter = new LocationAdapter(this, locations);
        locationListView.setAdapter(adapter);

        LocationDatabaseHelper dbHelper = new LocationDatabaseHelper(this);
        Cursor cursor = dbHelper.findAllLocationsCursor();
        String[] fromColumns = {
                LocationContract.LocationEntry.COLUMN_NAME_DESCRIPTION,
                LocationContract.LocationEntry.COLUMN_NAME_LAT,
                LocationContract.LocationEntry.COLUMN_NAME_LONG
        };

        int[] toViews = {R.id.locationNameTextView};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.location_item,
                cursor,
                fromColumns,
                toViews,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        locationListView.setAdapter(cursorAdapter);


        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if(Build.VERSION.SDK_INT < 23){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String []{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            currentLat = lastKnownLocation.getLatitude();
            currentLong = lastKnownLocation.getLongitude();
        }
    }
}
