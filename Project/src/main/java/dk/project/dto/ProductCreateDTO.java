// Package
package dk.project.dto;

public class ProductCreateDTO {

    // Attributes
    private String barcode;
    private String title;
    private int productInfoId;
    private int categoryId;

    // _______________________________________________________________________

    public ProductCreateDTO() {
    }

    // _______________________________________________________________________

    public ProductCreateDTO(String barcode, String title, int productInfoId, int categoryId) {
        this.barcode = barcode;
        this.title = title;
        this.productInfoId = productInfoId;
        this.categoryId = categoryId;
    }

    // _______________________________________________________________________

    public String getBarcode() {
        return barcode;
    }

    // _______________________________________________________________________

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    // _______________________________________________________________________

    public String getTitle() {
        return title;
    }

    // _______________________________________________________________________

    public void setTitle(String title) {
        this.title = title;
    }

    // _______________________________________________________________________

    public int getProductInfoId() {
        return productInfoId;
    }

    // _______________________________________________________________________

    public void setProductInfoId(int productInfoId) {
        this.productInfoId = productInfoId;
    }

    // _______________________________________________________________________

    public int getCategoryId() {
        return categoryId;
    }

    // _______________________________________________________________________

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}