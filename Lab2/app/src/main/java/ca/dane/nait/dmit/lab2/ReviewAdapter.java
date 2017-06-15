package ca.dane.nait.dmit.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ca.dane.nait.dmit.lab2.model.Review;

/**
 * Created by dchristenson5 on 6/14/2017.
 */

public class ReviewAdapter extends BaseAdapter {

    private Context mContext;
    private List<Review> mReviews;
    private LayoutInflater mInflater;

    public ReviewAdapter(Context mContext, List<Review> mReviews){
        this.mContext = mContext;
        this.mReviews = mReviews;

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mReviews.size();
    }

    @Override
    public Object getItem(int position) {
        return mReviews.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.review_item, null);

        Review currentReview = (Review) getItem(position);
        TextView descriptionTextView = (TextView) rowView.findViewById(R.id.descriptionTextView);
        TextView categoryTextView = (TextView) rowView.findViewById(R.id.categoryTextView);
        TextView addInfoTextView = (TextView) rowView.findViewById(R.id.addInfoTextView);
        TextView ratingTextView = (TextView) rowView.findViewById(R.id.ratingTextView);
        TextView reviewTextView = (TextView) rowView.findViewById(R.id.reviewTextView);
        TextView aliasTextView = (TextView) rowView.findViewById(R.id.aliasTextView);
        descriptionTextView.setText( currentReview.description );
        categoryTextView.setText( currentReview.category);
        addInfoTextView.setText(currentReview.addInfo);
        ratingTextView.setText(currentReview.rating);
        aliasTextView.setText(currentReview.alias);
        reviewTextView.setText( currentReview.review);
        return rowView;
    }

    @Override
    public long getItemId(int position) {
        Review currentReview = (Review) getItem(position);
        return currentReview.id;
    }
}