package ca.dane.dmit.homewifi;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.dane.dmit.homewifi.LocationModel.LocationDatabaseHelper;

/**
 * Created by super on 8/6/2017.
 */


public class AddLocation extends AppCompatActivity {

    private EditText mAddLocationEditText;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_location);

        mAddLocationEditText = (EditText) findViewById(R.id.addLocationEditText);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

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
    }

    public void onAddLocation(View view){
        String description = mAddLocationEditText.getText().toString();
        // add get latlng code here
        if(Build.VERSION.SDK_INT < 23){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String []{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            double currentLat = lastKnownLocation.getLatitude();
            double currentLong = lastKnownLocation.getLongitude();

            LocationDatabaseHelper dbHelper = new LocationDatabaseHelper(this);
            ca.dane.dmit.homewifi.LocationModel.Location currentLocation = new ca.dane.dmit.homewifi.LocationModel.Location(description, currentLat, currentLong);
            dbHelper.addLocation(currentLocation);

            mAddLocationEditText.setText("");

        }
    }
}
