package ca.dane.nait.dmit.lab2.model;

/**
 * Created by dchristenson5 on 6/12/2017.
 */

public class Review {
    public int id;
    public String category; //food or movies
    public String description; //Name of the place/thing
    public String addInfo; //address of restaurant
    public String review; // Actual Review
    public int rating;
    public String alias;

    public Review(int id, String category, String description, String addInfo, String review, int rating) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.addInfo = addInfo;
        this.review = review;
        this.rating = rating;
    }
    public Review(String category, String description, String addInfo, String review, int rating) {
        this.category = category;
        this.description = description;
        this.addInfo = addInfo;
        this.review = review;
        this.rating = rating;
    }

}