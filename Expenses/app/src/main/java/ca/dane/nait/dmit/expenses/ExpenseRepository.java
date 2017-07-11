package ca.dane.nait.dmit.expenses;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by dchristenson5 on 7/10/2017.
 */

public class ExpenseRepository {
    private static ExpenseRepository sExpenseRepository;
    private List<Expense> mExpenses;

    public static ExpenseRepository getInstance(Context context) {
        if(sExpenseRepository == null){
            sExpenseRepository = new ExpenseRepository(context);
        }
        return sExpenseRepository; }

    private ExpenseRepository(Context context){
        mExpenses = new ArrayList<>();
        //create 100 sample expenses;
        Random numberGenerator = new Random();
        for(int i = 1; i <= 100; i++){
            Expense currentExpense = new Expense();
            currentExpense.setDescription("Expense #" + i);
            //assign a random amount between 1 and 100;
            currentExpense.setAmount(numberGenerator.nextDouble() * 100);
            mExpenses.add(currentExpense);
        }
    }

    public List<Expense> getExpenses(){
        return mExpenses;
    }

    public Expense getExpense(UUID id){
        for (Expense currentExpense : mExpenses) {
            if(currentExpense.getId().equals(id)){
                return currentExpense;
            }
        }

        return null;
    }
}
