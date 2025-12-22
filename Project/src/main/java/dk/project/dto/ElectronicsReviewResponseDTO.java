// Package
package dk.project.dto;

public class ElectronicsReviewResponseDTO {

    // Attributes
    private int id;
    private int rating;
    private boolean wouldRecommend;
    private String comment;
    private String username;
    private String reviewDate;

    // _______________________________________________________________

    public ElectronicsReviewResponseDTO() {
    }

    // _______________________________________________________________

    public ElectronicsReviewResponseDTO(int id, int rating, boolean wouldRecommend,
                                        String comment, String username,
                                        String reviewDate) {
        this.id = id;
        this.rating = rating;
        this.wouldRecommend = wouldRecommend;
        this.comment = comment;
        this.username = username;
        this.reviewDate = reviewDate;
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

    public int getRating() {
        return rating;
    }

    // _______________________________________________________________

    public void setRating(int rating) {
        this.rating = rating;
    }

    // _______________________________________________________________

    public boolean isWouldRecommend() {
        return wouldRecommend;
    }

    // _______________________________________________________________

    public void setWouldRecommend(boolean wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
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

    public String getUsername() {
        return username;
    }

    // _______________________________________________________________

    public void setUsername(String username) {
        this.username = username;
    }

    // _______________________________________________________________

    public String getReviewDate() {
        return reviewDate;
    }

    // _______________________________________________________________

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

}