// Attributes
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class ProductBadge {

    // Attributes
    private int id;
    private String productBarcode;
    private int badgeId;
    private LocalDateTime added;

    // ______________________________________________________

    public ProductBadge(int id, String productBarcode, int badgeId, LocalDateTime added){
        this.id = id;
        this.productBarcode = productBarcode;
        this.badgeId = badgeId;
        this.added = added;
    }

    // ______________________________________________________

    public ProductBadge(String productBarcode, int badgeId, LocalDateTime added){
        this.productBarcode = productBarcode;
        this.badgeId = badgeId;
        this.added = added;
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

    // ______________________________________________________

    public LocalDateTime getAdded() {
        return added;
    }

    // ______________________________________________________

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

}