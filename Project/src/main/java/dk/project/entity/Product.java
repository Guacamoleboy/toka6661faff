// Package
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class Product {

    // Attributes
    private String barcode;
    private String title;
    private ProductInfo productInfo;
    private String imagePath;
    private int categoryId;
    private int subcategoryId;
    private LocalDateTime createdAt;

    // ___________________________________________________________

    public Product() {
    }

    // ___________________________________________________________

    public Product(String barcode, String title, ProductInfo productInfo, int categoryId, LocalDateTime createdAt, String imagePath, int subcategoryId) {
        this.barcode = barcode;
        this.title = title;
        this.productInfo = productInfo;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.imagePath = imagePath;
        this.subcategoryId = subcategoryId;
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

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    // ___________________________________________________________

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
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

    // ___________________________________________________________

    public int getSubcategoryId() {
        return subcategoryId;
    }

    // ___________________________________________________________

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    // ___________________________________________________________

    public String getImagePath() {
        return imagePath;
    }

    // ___________________________________________________________

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}