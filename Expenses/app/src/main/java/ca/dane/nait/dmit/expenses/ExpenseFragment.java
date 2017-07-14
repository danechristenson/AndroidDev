package ca.dane.nait.dmit.expenses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by dchristenson5 on 7/14/2017.
 */

public class ExpenseFragment extends Fragment {

    private Expense mExpense;
    private EditText mDescription;
    private EditText mAmount;
    private Button mDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_expense, container, false);

        mDescription = (EditText) view.findViewById(R.id.expense_description);
        mAmount = (EditText) view.findViewById(R.id.expense_amount);
        mDate = (Button) view.findViewById(R.id.expense_date);

        mDescription.setText(mExpense.getDescription());
        mAmount.setText(mExpense.getAmount() + "");
        mDate.setText(mExpense.getDate().toString());
        
        return view;

    }
}
