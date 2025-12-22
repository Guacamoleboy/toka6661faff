// Package
package dk.project.dto;

public class FoodReviewResponseDTO {

    // Attributes
    private int id;
    private int rating;
    private int priceRating;
    private int flavorRating;
    private boolean wouldBuyAgain;
    private String comment;
    private String username;
    private String reviewDate;

    // __________________________________________________________

    public FoodReviewResponseDTO() {
    }

    // __________________________________________________________

    public FoodReviewResponseDTO(int id, int rating, int priceRating, int flavorRating,
                                 boolean wouldBuyAgain, String comment,
                                 String username, String reviewDate) {
        this.id = id;
        this.rating = rating;
        this.priceRating = priceRating;
        this.flavorRating = flavorRating;
        this.wouldBuyAgain = wouldBuyAgain;
        this.comment = comment;
        this.username = username;
        this.reviewDate = reviewDate;
    }

    // __________________________________________________________

    public int getId() {
        return id;
    }

    // __________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // __________________________________________________________

    public int getRating() {
        return rating;
    }

    // __________________________________________________________

    public void setRating(int rating) {
        this.rating = rating;
    }

    // __________________________________________________________

    public int getPriceRating() {
        return priceRating;
    }

    // __________________________________________________________

    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    // __________________________________________________________

    public int getFlavorRating() {
        return flavorRating;
    }

    // __________________________________________________________

    public void setFlavorRating(int flavorRating) {
        this.flavorRating = flavorRating;
    }

    // __________________________________________________________

    public boolean isWouldBuyAgain() {
        return wouldBuyAgain;
    }

    // __________________________________________________________

    public void setWouldBuyAgain(boolean wouldBuyAgain) {
        this.wouldBuyAgain = wouldBuyAgain;
    }

    // __________________________________________________________

    public String getComment() {
        return comment;
    }

    // __________________________________________________________

    public void setComment(String comment) {
        this.comment = comment;
    }

    // __________________________________________________________

    public String getUsername() {
        return username;
    }

    // __________________________________________________________

    public void setUsername(String username) {
        this.username = username;
    }

    // __________________________________________________________

    public String getReviewDate() {
        return reviewDate;
    }

    // __________________________________________________________

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

}