package ca.dane.nait.dmit.lab2take2.model;

/**
 * Created by super on 7/9/2017.
 */

public class Category {
    public int id;
    public String category;

    public Category(int id, String category){
        this.id = id;
        this.category = category;
    }

    public Category(String category){
        this.category = category;
    }
}
