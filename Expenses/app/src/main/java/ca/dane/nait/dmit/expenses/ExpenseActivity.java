package ca.dane.nait.dmit.expenses;

import android.support.v4.app.Fragment;

/**
 * Created by dchristenson5 on 7/14/2017.
 */

public class ExpenseActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ExpenseFragment();
    }
}
