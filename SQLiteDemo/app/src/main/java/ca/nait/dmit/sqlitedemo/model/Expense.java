package ca.nait.dmit.sqlitedemo.model;

/**
 * Created by swu on 6/5/2017.
 */

public class Expense {

    public int id;
    public String description;
    public float amount;
    public String date;

    public Expense(int id, String description, float amount, String date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Expense(String description, float amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
}
