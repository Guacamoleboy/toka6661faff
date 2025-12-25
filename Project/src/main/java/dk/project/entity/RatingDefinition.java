// Package
package dk.project.entity;

public class RatingDefinition {

    // Attributes
    private int id;
    private int subcategoryId;
    private String label;
    private String ratingType;

    // _____________________________________________________________

    public RatingDefinition(){}

    // _____________________________________________________________

    public RatingDefinition(int id, int subcategoryId, String label, String ratingType){
        this.id = id;
        this.subcategoryId = subcategoryId;
        this.label = label;
        this.ratingType = ratingType;
    }

    // _____________________________________________________________

    public RatingDefinition(int subcategoryId, String label, String ratingType){
        this.subcategoryId = subcategoryId;
        this.label = label;
        this.ratingType = ratingType;
    }

    // _____________________________________________________________

    public String getRatingType() {
        return ratingType;
    }

    // _____________________________________________________________

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    // _____________________________________________________________

    public int getId() {
        return id;
    }

    // _____________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // _____________________________________________________________

    public int getSubcategoryId() {
        return subcategoryId;
    }

    // _____________________________________________________________

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    // _____________________________________________________________

    public String getLabel() {
        return label;
    }

    // _____________________________________________________________

    public void setLabel(String label) {
        this.label = label;
    }

}