package ca.dane.nait.dmit.expenses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by dchristenson5 on 7/10/2017.
 */

public class ExpenseListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ExpenseAdapter mExpenseAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expense_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.expense_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){
        ExpenseRepository expenseRepo = ExpenseRepository.getInstance(getActivity());
        List<Expense> expenses = expenseRepo.getExpenses();

        mExpenseAdapter = new ExpenseAdapter(expenses);
        mRecyclerView.setAdapter(mExpenseAdapter);
    }

    // define the ViewHolder that will inflate and own the layout
    private class ExpenseHolder extends RecyclerView.ViewHolder {

        private TextView mDescriptionTextView;
        private TextView mAmountTextView;
        private TextView mDateTextView;
        private Expense mExpense;

        // lets you find each item only once. can also be used with ListView
        public ExpenseHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_expense, parent, false));

            mDescriptionTextView = (TextView) itemView.findViewById(R.id.expense_description);
            mAmountTextView = (TextView) itemView.findViewById(R.id.expense_amount);
            mDateTextView = (TextView) itemView.findViewById(R.id.expense_date);
        }

        public void bind(Expense currentExpense){
            mExpense = currentExpense;
            mDescriptionTextView.setText(mExpense.getDescription());
            mAmountTextView.setText(mExpense.getAmount() + "");
            mDateTextView.setText(mExpense.getDate().toString());
        }
    }

    //Create adapter for the recyclerView
    private class ExpenseAdapter extends RecyclerView.Adapter<ExpenseHolder>{

        private List<Expense> mExpenses;

        public ExpenseAdapter(List<Expense> expenses){
            mExpenses = expenses;
        }

        @Override
        public ExpenseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new ExpenseHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(ExpenseHolder holder, int position) {
            Expense currentExpense = mExpenses.get(position);
            holder.bind(currentExpense);
        }

        @Override
        public int getItemCount() {
            return mExpenses.size();
        }


    }

}
