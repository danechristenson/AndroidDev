package ca.dane.nait.dmit.itunes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dchristenson5 on 6/19/2017.
 */

public class TrackAdapter extends BaseAdapter{
    private Context mContext;
    private List<Track> mDataSource;
    private LayoutInflater mInflater;

    public TrackAdapter(Context mContext, List<Track> mDataSource) {
        this.mContext = mContext;
        this.mDataSource = mDataSource;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.track_item, null);

        Track currentTrack = (Track) getItem(position);
        TextView trackNameTextView = (TextView) rowView.findViewById(R.id.activity_main_trackNameTextView);
        TextView artistNameTextView = (TextView) rowView.findViewById(R.id.activity_main_artistNameTextView);
        trackNameTextView.setText(currentTrack.getTrackName());
        artistNameTextView.setText(currentTrack.getArtistName());

        return rowView;
    }
}
