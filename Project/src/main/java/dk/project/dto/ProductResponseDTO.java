// Package
package dk.project.dto;

public class ProductResponseDTO {

    // Attributes
    private String barcode;
    private String title;
    private String category;
    private String description;

    // _________________________________________________________________

    public ProductResponseDTO() {
    }

    // _________________________________________________________________

    public ProductResponseDTO(String barcode, String title, String category, String description) {
        this.barcode = barcode;
        this.title = title;
        this.category = category;
        this.description = description;
    }

    // _________________________________________________________________

    public String getBarcode() {
        return barcode;
    }

    // _________________________________________________________________

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    // _________________________________________________________________

    public String getTitle() {
        return title;
    }

    // _________________________________________________________________

    public void setTitle(String title) {
        this.title = title;
    }

    // _________________________________________________________________

    public String getCategory() {
        return category;
    }

    // _________________________________________________________________

    public void setCategory(String category) {
        this.category = category;
    }

    // _________________________________________________________________

    public String getDescription() {
        return description;
    }

    // _________________________________________________________________

    public void setDescription(String description) {
        this.description = description;
    }

}