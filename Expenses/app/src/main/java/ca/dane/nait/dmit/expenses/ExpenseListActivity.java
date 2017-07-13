package ca.dane.nait.dmit.expenses;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExpenseListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ExpenseListFragment();
    }
}
