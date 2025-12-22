// Package
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class FoodReview {

    // Attributes
    private int id;
    private String productBarcode;
    private int userId;
    private int rating;
    private int priceRating;
    private int flavorRating;
    private boolean wouldBuyAgain;
    private String improvements;
    private String comment;
    private LocalDateTime reviewDate;

    // _______________________________________________________________

    public FoodReview() {
    }

    // _______________________________________________________________

    public FoodReview(int id, String productBarcode, int userId, int rating, int priceRating,
    int flavorRating, boolean wouldBuyAgain, String improvements,
    String comment, LocalDateTime reviewDate) {
        this.id = id;
        this.productBarcode = productBarcode;
        this.userId = userId;
        this.rating = rating;
        this.priceRating = priceRating;
        this.flavorRating = flavorRating;
        this.wouldBuyAgain = wouldBuyAgain;
        this.improvements = improvements;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // _______________________________________________________________

    public FoodReview(String productBarcode, int userId, int rating, int priceRating,
    int flavorRating, boolean wouldBuyAgain, String improvements,
    String comment) {
        this.productBarcode = productBarcode;
        this.userId = userId;
        this.rating = rating;
        this.priceRating = priceRating;
        this.flavorRating = flavorRating;
        this.wouldBuyAgain = wouldBuyAgain;
        this.improvements = improvements;
        this.comment = comment;
    }

    // _______________________________________________________________

    public int getId() {
        return id;
    }

    // _______________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // _______________________________________________________________

    public String getProductBarcode() {
        return productBarcode;
    }

    // _______________________________________________________________

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    // _______________________________________________________________

    public int getUserId() {
        return userId;
    }

    // _______________________________________________________________

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // _______________________________________________________________

    public int getRating() {
        return rating;
    }

    // _______________________________________________________________

    public void setRating(int rating) {
        this.rating = rating;
    }

    // _______________________________________________________________

    public int getPriceRating() {
        return priceRating;
    }

    // _______________________________________________________________

    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    // _______________________________________________________________

    public int getFlavorRating() {
        return flavorRating;
    }

    // _______________________________________________________________

    public void setFlavorRating(int flavorRating) {
        this.flavorRating = flavorRating;
    }

    // _______________________________________________________________

    public boolean isWouldBuyAgain() {
        return wouldBuyAgain;
    }

    // _______________________________________________________________

    public void setWouldBuyAgain(boolean wouldBuyAgain) {
        this.wouldBuyAgain = wouldBuyAgain;
    }

    // _______________________________________________________________

    public String getImprovements() {
        return improvements;
    }

    // _______________________________________________________________

    public void setImprovements(String improvements) {
        this.improvements = improvements;
    }

    // _______________________________________________________________

    public String getComment() {
        return comment;
    }

    // _______________________________________________________________

    public void setComment(String comment) {
        this.comment = comment;
    }

    // _______________________________________________________________

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    // _______________________________________________________________

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

}