package ca.dane.nait.dmit.customlistviewdemo01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by dchristenson5 on 5/31/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Jitter> mJitters;
    private LayoutInflater mInflater;

    public ListViewAdapter(Context mContext, ArrayList<Jitter> mJitters) {
        this.mContext = mContext;
        this.mJitters = mJitters;

        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mJitters.size();
    }

    @Override
    public Object getItem(int position) {
        return mJitters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.jitter_list_item, null);
        return rowView;
    }
}
