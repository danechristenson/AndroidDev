package ca.dane.dmit.homewifi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ca.dane.dmit.homewifi.LocationModel.LocationAdapter;
import ca.dane.dmit.homewifi.LocationModel.LocationContract;
import ca.dane.dmit.homewifi.LocationModel.LocationDatabaseHelper;


public class WifiToggle extends AppCompatActivity {

    TextView descriptionTextView;
    LocationManager locationManager;
    LocationListener locationListener;
    WifiManager wifiManager;
    List<ca.dane.dmit.homewifi.LocationModel.Location> locationsList;

    double currentLat, currentLong;

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

    public void viewMap(View view){
        Intent viewMapIntent = new Intent(this, MapView.class);
        startActivity(viewMapIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_toggle);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        ListView locationListView = (ListView) findViewById(R.id.locationListView);
        descriptionTextView = (TextView) findViewById(R.id.locationNameTextView);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        final WifiInfo wifi = wifiManager.getConnectionInfo();

        final List<ca.dane.dmit.homewifi.LocationModel.Location> locations = new ArrayList<>();
        LocationAdapter adapter = new LocationAdapter(this, locations);
        locationListView.setAdapter(adapter);

        final LocationDatabaseHelper dbHelper = new LocationDatabaseHelper(this);
        final Cursor cursor = dbHelper.findAllLocationsCursor();
        String[] fromColumns = {
                LocationContract.LocationEntry.COLUMN_NAME_DESCRIPTION,
                LocationContract.LocationEntry.COLUMN_NAME_LAT,
                LocationContract.LocationEntry.COLUMN_NAME_LONG,
                LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE
        };

        int[] toViews = {R.id.locationNameTextView};
        final SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.location_item,
                cursor,
                fromColumns,
                toViews,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        locationsList = dbHelper.findAllLocations();

        locationListView.setAdapter(cursorAdapter);
        locationListView.setItemsCanFocus(true);



        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(android.location.Location location) {
                if(wifi.getNetworkId() == -1){
                    for(int i = 0; i < locationsList.size(); i++){
                        ca.dane.dmit.homewifi.LocationModel.Location currentLocation = locationsList.get(i);
                        if(currentLocation.isActive){
                            if(currentLong == currentLocation.lng && currentLat == currentLocation.lat){
                                wifiManager.setWifiEnabled(true);
                            }
                        }


                    }
                    if(wifiManager.isWifiEnabled() == true){
                        wifiManager.setWifiEnabled(false);
                    }

                }
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
