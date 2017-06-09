package ca.dane.nait.dmit.lab1;

import android.content.Context;
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
        View inflatedView = mInflater.inflate(R.layout.list_view_item, null);

        Review reviews = (Review) getItem(position);
        TextView timeTextView = (TextView) inflatedView.findViewById(R.id.time_textview);
        TextView reviewerTextView = (TextView) inflatedView.findViewById(R.id.reviewer_textview);
        TextView categoryTextView = (TextView) inflatedView.findViewById(R.id.category_textview);
        TextView nomineeTextView = (TextView) inflatedView.findViewById(R.id.nominee_textview);
        TextView reviewTextView = (TextView) inflatedView.findViewById(R.id.review_textview);

        timeTextView.setText(reviews.time);
        reviewerTextView.setText(reviews.reviewer);
        categoryTextView.setText(reviews.category);
        nomineeTextView.setText(reviews.nominee);
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
