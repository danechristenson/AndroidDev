package ca.dane.dmit.quiz02danechristenson;

import android.content.Context;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by dchristenson5 on 7/19/2017.
 */

public class TrackAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Track> mTrack;
    private LayoutInflater mInflater;

    public TrackAdapter(Context mContext, ArrayList<Track> mTrack){
        this.mContext = mContext;
        this.mTrack = mTrack;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mTrack.size();
    }

    @Override
    public Object getItem(int position) {
        return mTrack.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflatedView = mInflater.inflate(R.layout.list_view_item, null);

        Track tracks = (Track) getItem(position);
        TextView timeTextView = (TextView) inflatedView.findViewById(R.id.time_textview);
        TextView amountTextView = (TextView) inflatedView.findViewById(R.id.amount_textView);
        TextView track = (TextView) inflatedView.findViewById(R.id.track_textView);

        String date = String.format("%1$tY-%1$tm-%1$td", tracks.getDate() );

        timeTextView.setText(date);

        amountTextView.setText("$" + tracks.getAmount());
        track.setText(tracks.getDescription());

        return inflatedView;
    }
}
