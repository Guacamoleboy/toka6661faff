// Package
package dk.project.dto;

public class ProductInfoResponseDTO {

    // Attributes
    private int id;
    private String name;
    private String description;

    // _________________________________________________________

    public ProductInfoResponseDTO() {
    }

    // _________________________________________________________

    public ProductInfoResponseDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // _________________________________________________________

    public int getId() {
        return id;
    }

    // _________________________________________________________

    public void setId(int id) {
        this.id = id;
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