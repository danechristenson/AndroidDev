package ca.nait.dmit.sqlitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ca.nait.dmit.sqlitedemo.model.Expense;

/**
 * Created by swu on 6/5/2017.
 */

public class ExpensesAdapter extends BaseAdapter {

    private Context mContext;
    private List<Expense> mExpenses;
    private LayoutInflater mInflater;

    public ExpensesAdapter(Context mContext, List<Expense> mExpenses) {
        this.mContext = mContext;
        this.mExpenses = mExpenses;

        mInflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mExpenses.size();
    }

    @Override
    public Object getItem(int position) {
        return mExpenses.get(position);
    }

    @Override
    public long getItemId(int position) {
        Expense currentExpense = (Expense) getItem(position);
        return currentExpense.id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.expense_item, null);

        Expense currentExpense = (Expense) getItem(position);
        TextView descriptionTextView = (TextView) rowView.findViewById(
                R.id.descriptionTextView);
        TextView amountTextView = (TextView) rowView.findViewById(R.id.amounTextView);
        TextView dateTextView = (TextView) rowView.findViewById(R.id.dateTextView);
        descriptionTextView.setText( currentExpense.description );
        amountTextView.setText( currentExpense.amount + "" );
        dateTextView.setText( currentExpense.date );
        return rowView;
    }
}
