// Package
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class Review {

    // Attributes
    private int id;
    private String productBarcode;
    private int userId;
    private String finalComment;
    private LocalDateTime createdAt;

    // ______________________________________________________________

    public Review(){}

    // ______________________________________________________________

    public Review(int id, String productBarcode, int userId, String finalComment, LocalDateTime createdAt){
        this.id = id;
        this.productBarcode = productBarcode;
        this.userId = userId;
        this.finalComment = finalComment;
        this.createdAt = createdAt;
    }

    // ______________________________________________________________

    public Review(String productBarcode, int userId, String finalComment, LocalDateTime createdAt){
        this.productBarcode = productBarcode;
        this.userId = userId;
        this.finalComment = finalComment;
        this.createdAt = createdAt;
    }

    // ______________________________________________________________

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ______________________________________________________________

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ______________________________________________________________

    public int getId() {
        return id;
    }

    // ______________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // ______________________________________________________________

    public String getProductBarcode() {
        return productBarcode;
    }

    // ______________________________________________________________

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    // ______________________________________________________________

    public int getUserId() {
        return userId;
    }

    // ______________________________________________________________

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // ______________________________________________________________

    public String getFinalComment() {
        return finalComment;
    }

    // ______________________________________________________________

    public void setFinalComment(String finalComment) {
        this.finalComment = finalComment;
    }

}