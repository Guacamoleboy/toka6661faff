// Package
package dk.project.entity;

public class Category {

    // Attributes
    private int id;
    private String name;
    private String description;

    // _________________________________________________________________

    public Category() {
    }

    // _________________________________________________________________

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // _________________________________________________________________

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // _________________________________________________________________

    public int getId() {
        return id;
    }

    // _________________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // _________________________________________________________________

    public String getName() {
        return name;
    }

    // _________________________________________________________________

    public void setName(String name) {
        this.name = name;
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