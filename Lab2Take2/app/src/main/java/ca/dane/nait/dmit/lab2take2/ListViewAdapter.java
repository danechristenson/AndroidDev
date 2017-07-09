package ca.dane.nait.dmit.lab2take2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dane on 6/7/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Review> mReview;
    private LayoutInflater mInflater;

    public ListViewAdapter(Context mContext, ArrayList<Review> mReview){
        this.mContext = mContext;
        this.mReview = mReview;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return mReview.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflatedView = mInflater.inflate(R.layout.review_list_item, null);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String fontColorPref = prefs.getString("preference_font_color", "#FFFFFF");

        Review reviews = (Review) getItem(position);
        TextView aliasTextView = (TextView) inflatedView.findViewById(R.id.view_review_AliasTextView);
        TextView addInfoTextView = (TextView) inflatedView.findViewById(R.id.view_review_AddInfoTextView);
        TextView categoryTextView = (TextView) inflatedView.findViewById(R.id.view_review_CategoryTextView);
        TextView desciptionTextView = (TextView) inflatedView.findViewById(R.id.view_review_DescriptionTextView);
        TextView reviewTextView = (TextView) inflatedView.findViewById(R.id.view_review_ReviewTextView);

        aliasTextView.setTextColor(Color.parseColor(fontColorPref));
        addInfoTextView.setTextColor(Color.parseColor(fontColorPref));
        categoryTextView.setTextColor(Color.parseColor(fontColorPref));
        desciptionTextView.setTextColor(Color.parseColor(fontColorPref));
        reviewTextView.setTextColor(Color.parseColor(fontColorPref));

        aliasTextView.setText(reviews.alias);
        addInfoTextView.setText(reviews.addInfo);
        categoryTextView.setText(reviews.category);
        desciptionTextView.setText(reviews.description);
        reviewTextView.setText(reviews.review);

        return inflatedView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mReview.size();
    }
}
