// Package
package dk.project.dto;

public class ProductInfoCreateDTO {

    // Attributes
    private String name;
    private String description;

    // _________________________________________________________

    public ProductInfoCreateDTO() {
    }

    // _________________________________________________________

    public ProductInfoCreateDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // _________________________________________________________

    public String getName() {
        return name;
    }

    // _________________________________________________________

    public void setName(String name) {
        this.name = name;
    }

    // _________________________________________________________

    public String getDescription() {
        return description;
    }

    // _________________________________________________________

    public void setDescription(String description) {
        this.description = description;
    }

}