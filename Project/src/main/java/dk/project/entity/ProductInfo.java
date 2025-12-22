// Package
package dk.project.entity;

public class ProductInfo {

    // Attributes
    private int id;
    private String name;
    private String description;

    // ___________________________________________________________

    public ProductInfo() {
    }

    // ___________________________________________________________

    public ProductInfo(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // ___________________________________________________________

    public ProductInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ___________________________________________________________

    public int getId() {
        return id;
    }

    // ___________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // ___________________________________________________________

    public String getName() {
        return name;
    }

    // ___________________________________________________________

    public void setName(String name) {
        this.name = name;
    }

    // ___________________________________________________________

    public String getDescription() {
        return description;
    }

    // ___________________________________________________________

    public void setDescription(String description) {
        this.description = description;
    }

}