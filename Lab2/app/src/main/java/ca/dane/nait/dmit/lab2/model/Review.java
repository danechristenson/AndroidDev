package ca.dane.nait.dmit.lab2.model;

/**
 * Created by dchristenson5 on 6/12/2017.
 */

public class Review {
    public int id;
    public String category;
    public String description;
    public String addInfo;
    public String review;
    public short rating;
    public String alias;

    public Review(int id, String category, String description, String addInfo, String review, short rating,String alias) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.addInfo = addInfo;
        this.review = review;
        this.rating = rating;
        this.alias = alias;
    }
}