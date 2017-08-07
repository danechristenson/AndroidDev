package ca.dane.dmit.homewifi.LocationModel;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

import ca.dane.dmit.homewifi.R;
import ca.dane.dmit.homewifi.WifiToggle;

/**
 * Created by super on 8/6/2017.
 */

public class LocationAdapter  extends BaseAdapter{

    private Context mContext;
    private List<Location> mLocations;
    private LayoutInflater mInflater;

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
        final View rowView = mInflater.inflate(R.layout.location_item, null);
        final Location currentLocation = (Location) getItem(position);
        TextView descriptionTextView = (TextView) rowView.findViewById(R.id.locationNameTextView);
        descriptionTextView.setText(currentLocation.description);

        final Switch wifiToggle = (Switch) rowView.findViewById(R.id.wifiToggleButton);
        final Button deleteButton = (Button) rowView.findViewById(R.id.deleteLocationButton);
        LocationDatabaseHelper dbHelper = new LocationDatabaseHelper(mContext);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        //        wifiToggle.setOnClickListener(mGlobal_OnClickListener);
//        deleteButton.setOnClickListener(mGlobal_OnClickListener);
//        rowView.findViewById(R.id.deleteLocationButton).setOnClickListener(mGlobal_OnClickListener);
//        rowView.findViewById(R.id.wifiToggleButton).setOnClickListener(mGlobal_OnClickListener);


//        wifiToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                ContentValues values = new ContentValues();
//                values.put(LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE, wifiToggle.isChecked() );
//                String where = LocationContract.LocationEntry._ID + " = " + currentLocation.id;
//                db.update(LocationContract.LocationEntry.TABLE_NAME, values, where, null);
//            }
//        });
//
//        if(wifiToggle.isPressed()) {
//            ContentValues values = new ContentValues();
//            values.put(LocationContract.LocationEntry.COLUMN_NAME_ISACTIVE, wifiToggle.isChecked());
//            String where = LocationContract.LocationEntry._ID + " = " + currentLocation.id;
//            db.update(LocationContract.LocationEntry.TABLE_NAME, values, where, null);
//            Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
//        }

        return rowView;
    }
}
