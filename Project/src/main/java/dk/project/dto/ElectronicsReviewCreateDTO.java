// Package
package dk.project.dto;

public class ElectronicsReviewCreateDTO {

    // Attributes
    private String productBarcode;
    private int rating;
    private Integer durabilityRating;
    private Integer easeOfUseRating;
    private Integer designRating;
    private boolean wouldRecommend;
    private String improvements;
    private String comment;

    // ____________________________________________________________________

    public ElectronicsReviewCreateDTO() {
    }

    // ____________________________________________________________________

    public ElectronicsReviewCreateDTO(String productBarcode, int rating,
                                      Integer durabilityRating, Integer easeOfUseRating,
                                      Integer designRating, boolean wouldRecommend,
                                      String improvements, String comment) {
        this.productBarcode = productBarcode;
        this.rating = rating;
        this.durabilityRating = durabilityRating;
        this.easeOfUseRating = easeOfUseRating;
        this.designRating = designRating;
        this.wouldRecommend = wouldRecommend;
        this.improvements = improvements;
        this.comment = comment;
    }

    // ____________________________________________________________________

    public String getProductBarcode() {
        return productBarcode;
    }

    // ____________________________________________________________________

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    // ____________________________________________________________________

    public int getRating() {
        return rating;
    }

    // ____________________________________________________________________

    public void setRating(int rating) {
        this.rating = rating;
    }

    // ____________________________________________________________________

    public Integer getDurabilityRating() {
        return durabilityRating;
    }

    // ____________________________________________________________________

    public void setDurabilityRating(Integer durabilityRating) {
        this.durabilityRating = durabilityRating;
    }

    // ____________________________________________________________________

    public Integer getEaseOfUseRating() {
        return easeOfUseRating;
    }

    // ____________________________________________________________________

    public void setEaseOfUseRating(Integer easeOfUseRating) {
        this.easeOfUseRating = easeOfUseRating;
    }

    // ____________________________________________________________________

    public Integer getDesignRating() {
        return designRating;
    }

    // ____________________________________________________________________

    public void setDesignRating(Integer designRating) {
        this.designRating = designRating;
    }

    // ____________________________________________________________________

    public boolean isWouldRecommend() {
        return wouldRecommend;
    }

    // ____________________________________________________________________

    public void setWouldRecommend(boolean wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
    }

    // ____________________________________________________________________

    public String getImprovements() {
        return improvements;
    }

    // ____________________________________________________________________

    public void setImprovements(String improvements) {
        this.improvements = improvements;
    }

    // ____________________________________________________________________

    public String getComment() {
        return comment;
    }

    // ____________________________________________________________________

    public void setComment(String comment) {
        this.comment = comment;
    }

}