// Attributes
package dk.project.entity;

public class ProductBadge {

    // Attributes
    private int id;
    private String productBarcode;
    private int badgeId;

    // ______________________________________________________

    public ProductBadge(){}

    // ______________________________________________________

    public ProductBadge(int id, String productBarcode, int badgeId){
        this.id = id;
        this.productBarcode = productBarcode;
        this.badgeId = badgeId;
    }

    // ______________________________________________________

    public ProductBadge(String productBarcode, int badgeId){
        this.productBarcode = productBarcode;
        this.badgeId = badgeId;
    }

    // ______________________________________________________

    public int getBadgeId() {
        return badgeId;
    }

    // ______________________________________________________

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    // ______________________________________________________

    public int getId() {
        return id;
    }

    // ______________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // ______________________________________________________

    public String getProductBarcode() {
        return productBarcode;
    }

    // ______________________________________________________

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

}