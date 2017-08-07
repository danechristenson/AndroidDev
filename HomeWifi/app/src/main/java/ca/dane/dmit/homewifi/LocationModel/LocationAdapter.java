package ca.dane.dmit.homewifi.LocationModel;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import ca.dane.dmit.homewifi.R;

/**
 * Created by super on 8/6/2017.
 */

public class LocationAdapter  extends BaseAdapter{

    private Context mContext;
    private List<Location> mLocations;
    private LayoutInflater mInflater;
    LocationManager locationManager;
    LocationListener locationListener;
    double currentLat, currentLong, homeLat, homeLong;

    public LocationAdapter(Context mContext, List<Location> mLocations) {
        this.mContext = mContext;
        this.mLocations = mLocations;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mLocations.size();
    }

    @Override
    public Object getItem(int position) {
        return mLocations.get(position);
    }

    @Override
    public long getItemId(int position) {
        Location currentLocation = (Location) getItem(position);
        return currentLocation.id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.location_item, null);

        Location currentLocation = (Location) getItem(position);
        TextView descriptionTextView = (TextView) rowView.findViewById(R.id.locationNameTextView);
        descriptionTextView.setText(currentLocation.description);
        final ToggleButton wifiToggle = (ToggleButton) rowView.findViewById(R.id.wifiToggleButton);
        final WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);



        wifiToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    wifiToggle.setText("Wifi is on");
                    wifiManager.setWifiEnabled(true);
                }
                else{
                    wifiToggle.setText("wifi is off");
                    wifiManager.setWifiEnabled(false);
                }
            }
        });
        if (wifiToggle.isChecked()) {
            wifiToggle.setText("Wifi is on");
            wifiManager.setWifiEnabled(true);
            // check if home is here and turn wifi on
//            wifiStateTextView.setText("Wifi is on");
        } else {
            wifiToggle.setText("wifi is off");
            wifiManager.setWifiEnabled(false);
        }


        return rowView;
    }
}
