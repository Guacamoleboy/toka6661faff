// Package
package dk.project.dto;

public class CategoryCreateDTO {

    // Attributes
    private String name;
    private String description;

    // _____________________________________________________________________

    public CategoryCreateDTO() {
    }

    // _____________________________________________________________________

    public CategoryCreateDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // _____________________________________________________________________

    public String getName() {
        return name;
    }

    // _____________________________________________________________________

    public void setName(String name) {
        this.name = name;
    }

    // _____________________________________________________________________

    public String getDescription() {
        return description;
    }

    // _____________________________________________________________________

    public void setDescription(String description) {
        this.description = description;
    }

}