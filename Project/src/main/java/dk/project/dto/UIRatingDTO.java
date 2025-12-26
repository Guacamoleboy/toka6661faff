// Package
package dk.project.dto;

public class UIRatingDTO {

    // Attributes
    private final String label;
    private final double average;

    // _____________________________________________________________________________

    public UIRatingDTO(String label, double average) {
        this.label = label;
        this.average = average;
    }

    // _____________________________________________________________________________

    public String getLabel() {
        return label;
    }

    // _____________________________________________________________________________

    public double getAverage() {
        return average;
    }

}