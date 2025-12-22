// Package
package dk.project.dto;

public class FoodReviewCreateDTO {

    // Attributes
    private String productBarcode;
    private int rating;
    private int priceRating;
    private int flavorRating;
    private boolean wouldBuyAgain;
    private String improvements;
    private String comment;

    // _________________________________________________________

    public FoodReviewCreateDTO() {
    }

    // _________________________________________________________

    public FoodReviewCreateDTO(String productBarcode, int rating, int priceRating,
                               int flavorRating, boolean wouldBuyAgain,
                               String improvements, String comment) {
        this.productBarcode = productBarcode;
        this.rating = rating;
        this.priceRating = priceRating;
        this.flavorRating = flavorRating;
        this.wouldBuyAgain = wouldBuyAgain;
        this.improvements = improvements;
        this.comment = comment;
    }

    // _________________________________________________________

    public String getProductBarcode() {
        return productBarcode;
    }

    // _________________________________________________________

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    // _________________________________________________________

    public int getRating() {
        return rating;
    }

    // _________________________________________________________

    public void setRating(int rating) {
        this.rating = rating;
    }

    // _________________________________________________________

    public int getPriceRating() {
        return priceRating;
    }

    // _________________________________________________________

    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    // _________________________________________________________

    public int getFlavorRating() {
        return flavorRating;
    }

    // _________________________________________________________

    public void setFlavorRating(int flavorRating) {
        this.flavorRating = flavorRating;
    }

    // _________________________________________________________

    public boolean isWouldBuyAgain() {
        return wouldBuyAgain;
    }

    // _________________________________________________________

    public void setWouldBuyAgain(boolean wouldBuyAgain) {
        this.wouldBuyAgain = wouldBuyAgain;
    }

    // _________________________________________________________

    public String getImprovements() {
        return improvements;
    }

    // _________________________________________________________

    public void setImprovements(String improvements) {
        this.improvements = improvements;
    }

    // _________________________________________________________

    public String getComment() {
        return comment;
    }

    // _________________________________________________________

    public void setComment(String comment) {
        this.comment = comment;
    }

}