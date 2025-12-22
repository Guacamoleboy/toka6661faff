// Package
package dk.project.entity;

public class Role {

    // Attributes
    private int id;
    private String name;

    // _______________________________________________________

    public Role() {
    }

    // _______________________________________________________

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // _______________________________________________________

    public Role(String name) {
        this.name = name;
    }

    // _______________________________________________________

    public int getId() {
        return id;
    }

    // _______________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // _______________________________________________________

    public String getName() {
        return name;
    }

    // _______________________________________________________

    public void setName(String name) {
        this.name = name;
    }

}