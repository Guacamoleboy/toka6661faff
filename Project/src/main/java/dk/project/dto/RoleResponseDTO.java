// Package
package dk.project.dto;

public class RoleResponseDTO {

    // Attributes
    private int id;
    private String name;

    // _______________________________________________________________

    public RoleResponseDTO() {
    }

    // _______________________________________________________________

    public RoleResponseDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // _______________________________________________________________

    public int getId() {
        return id;
    }

    // _______________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // _______________________________________________________________

    public String getName() {
        return name;
    }

    // _______________________________________________________________

    public void setName(String name) {
        this.name = name;
    }

}