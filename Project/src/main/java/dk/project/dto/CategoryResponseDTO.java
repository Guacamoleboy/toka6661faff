// Package
package dk.project.dto;

public class CategoryResponseDTO {

    // Attributes
    private int id;
    private String name;
    private String description;

    // _____________________________________________________________

    public CategoryResponseDTO() {
    }

    // _____________________________________________________________

    public CategoryResponseDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    // _____________________________________________________________

    public void setName(String name) {
        this.name = name;
    }

    // _____________________________________________________________

    public String getDescription() {
        return description;
    }

    // _____________________________________________________________

    public void setDescription(String description) {
        this.description = description;
    }

}