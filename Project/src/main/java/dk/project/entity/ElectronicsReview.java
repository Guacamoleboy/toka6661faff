// Package
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class ElectronicsReview {

    // Attributes
    private int id;
    private String productBarcode;
    private int userId;
    private int rating;
    private Integer durabilityRating;
    private Integer easeOfUseRating;
    private Integer designRating;
    private boolean wouldRecommend;
    private String improvements;
    private String comment;
    private LocalDateTime reviewDate;

    // __________________________________________________________________

    public ElectronicsReview() {
    }

    // __________________________________________________________________

    public ElectronicsReview(int id, String productBarcode, int userId, int rating,
                         Integer durabilityRating, Integer easeOfUseRating,
                         Integer designRating, boolean wouldRecommend,
                         String improvements, String comment,
                         LocalDateTime reviewDate) {
        this.id = id;
        this.productBarcode = productBarcode;
        this.userId = userId;
        this.rating = rating;
        this.durabilityRating = durabilityRating;
        this.easeOfUseRating = easeOfUseRating;
        this.designRating = designRating;
        this.wouldRecommend = wouldRecommend;
        this.improvements = improvements;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // __________________________________________________________________

    public ElectronicsReview(String productBarcode, int userId, int rating,
                             Integer durabilityRating, Integer easeOfUseRating,
                             Integer designRating, boolean wouldRecommend,
                             String improvements, String comment) {
        this.productBarcode = productBarcode;
        this.userId = userId;
        this.rating = rating;
        this.durabilityRating = durabilityRating;
        this.easeOfUseRating = easeOfUseRating;
        this.designRating = designRating;
        this.wouldRecommend = wouldRecommend;
        this.improvements = improvements;
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

    public String getProductBarcode() {
        return productBarcode;
    }

    // __________________________________________________________________

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    // __________________________________________________________________

    public int getUserId() {
        return userId;
    }

    // __________________________________________________________________

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // __________________________________________________________________

    public int getRating() {
        return rating;
    }

    // __________________________________________________________________

    public void setRating(int rating) {
        this.rating = rating;
    }

    // __________________________________________________________________

    public Integer getDurabilityRating() {
        return durabilityRating;
    }

    // __________________________________________________________________

    public void setDurabilityRating(Integer durabilityRating) {
        this.durabilityRating = durabilityRating;
    }

    // __________________________________________________________________

    public Integer getEaseOfUseRating() {
        return easeOfUseRating;
    }

    // __________________________________________________________________

    public void setEaseOfUseRating(Integer easeOfUseRating) {
        this.easeOfUseRating = easeOfUseRating;
    }

    // __________________________________________________________________

    public Integer getDesignRating() {
        return designRating;
    }

    // __________________________________________________________________

    public void setDesignRating(Integer designRating) {
        this.designRating = designRating;
    }

    // __________________________________________________________________

    public boolean isWouldRecommend() {
        return wouldRecommend;
    }

    // __________________________________________________________________

    public void setWouldRecommend(boolean wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
    }

    // __________________________________________________________________

    public String getImprovements() {
        return improvements;
    }

    // __________________________________________________________________

    public void setImprovements(String improvements) {
        this.improvements = improvements;
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

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    // __________________________________________________________________

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

}