package ca.dane.nait.dmit.expenses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;
import java.util.UUID;

/**
 * Created by dchristenson5 on 7/14/2017.
 */

public class ExpensePagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Expense> mExpenses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_pager);

        mViewPager = (ViewPager) findViewById(R.id.expense_view_pager);
        mExpenses = ExpenseRepository.getInstance(this).getExpenses();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Expense currentExpense = mExpenses.get(position);
                ExpenseFragment fragment = new ExpenseFragment();
                Bundle args = new Bundle();
                args.putSerializable("expense_id", currentExpense.getId());
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return mExpenses.size();
            }
        });

        UUID expenseId = (UUID) getIntent().getSerializableExtra("expense_id");
        for(int i = 0; i < mExpenses.size(); i++){
            if(mExpenses.get(i).getId().equals(expenseId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
