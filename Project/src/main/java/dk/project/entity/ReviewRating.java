// Package
package dk.project.entity;

public class ReviewRating {

    // Attributes
    private int id;
    private int reviewId;
    private int ratingDefinitionId;
    private double value;
    private String comment;

    // __________________________________________________________________
    // Unit Test

    public ReviewRating(){}

    // __________________________________________________________________

    public ReviewRating(int id, int reviewId, int ratingDefinitionId, double value, String comment){
        this.id = id;
        this.reviewId = reviewId;
        this.ratingDefinitionId = ratingDefinitionId;
        this.value = value;
        this.comment = comment;
    }

    // __________________________________________________________________

    public ReviewRating(int reviewId, int ratingDefinitionId, double value, String comment){
        this.reviewId = reviewId;
        this.ratingDefinitionId = ratingDefinitionId;
        this.value = value;
        this.comment = comment;
    }

    // __________________________________________________________________

    public String getComment() {
        return comment;
    }

    // __________________________________________________________________

    public void setComment(String comment) {
        this.comment = comment;
    }

    // __________________________________________________________________

    public int getId() {
        return id;
    }

    // __________________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // __________________________________________________________________

    public int getReviewId() {
        return reviewId;
    }

    // __________________________________________________________________

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    // __________________________________________________________________

    public int getRatingDefinitionId() {
        return ratingDefinitionId;
    }

    // __________________________________________________________________

    public void setRatingDefinitionId(int ratingDefinitionId) {
        this.ratingDefinitionId = ratingDefinitionId;
    }

    // __________________________________________________________________

    public double getValue() {
        return value;
    }

    // __________________________________________________________________

    public void setValue(double value) {
        this.value = value;
    }

}