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

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}