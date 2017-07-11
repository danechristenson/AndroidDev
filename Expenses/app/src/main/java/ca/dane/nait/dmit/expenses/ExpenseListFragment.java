package ca.dane.nait.dmit.expenses;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dchristenson5 on 7/10/2017.
 */

public class ExpenseListFragment extends Fragment {
    // define the ViewHolder that will inflate and own the layout
    private class ExpenseHolder extends RecyclerView.ViewHolder {

        private TextView mDesciptionTextView;
        private TextView mAmountTextView;
        private TextView mDateTextView;

        // lets you find each item only once. can also be used with ListView
        public ExpenseHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_expense, parent));

            mDesciptionTextView = (TextView) itemView.findViewById(R.id.expense_description);
            mAmountTextView = (TextView) itemView.findViewById(R.id.expense_amount);
            mDateTextView = (TextView) itemView.findViewById(R.id.expense_date);
        }
    }
}
