// Package
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class Product {

    // Attributes
    private String barcode;
    private String title;
    private int productInfoId;
    private int categoryId;
    private LocalDateTime createdAt;

    // ___________________________________________________________

    public Product() {
    }

    // ___________________________________________________________

    public Product(String barcode, String title, int productInfoId, int categoryId, LocalDateTime createdAt) {
        this.barcode = barcode;
        this.title = title;
        this.productInfoId = productInfoId;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
    }

    // ___________________________________________________________

    public Product(String barcode, String title, int productInfoId, int categoryId) {
        this.barcode = barcode;
        this.title = title;
        this.productInfoId = productInfoId;
        this.categoryId = categoryId;
    }

    // ___________________________________________________________

    public String getBarcode() {
        return barcode;
    }

    // ___________________________________________________________

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    // ___________________________________________________________

    public String getTitle() {
        return title;
    }

    // ___________________________________________________________

    public void setTitle(String title) {
        this.title = title;
    }

    // ___________________________________________________________

    public int getProductInfoId() {
        return productInfoId;
    }

    // ___________________________________________________________

    public void setProductInfoId(int productInfoId) {
        this.productInfoId = productInfoId;
    }

    // ___________________________________________________________

    public int getCategoryId() {
        return categoryId;
    }

    // ___________________________________________________________

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    // ___________________________________________________________

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ___________________________________________________________

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}