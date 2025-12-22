// Package
package dk.project.dto;

public class RoleCreateDTO {

    // Attributes
    private String name;

    // ___________________________________________________

    public RoleCreateDTO() {
    }

    // ___________________________________________________

    public RoleCreateDTO(String name) {
        this.name = name;
    }

    // ___________________________________________________

    public String getName() {
        return name;
    }

    // ___________________________________________________

    public void setName(String name) {
        this.name = name;
    }

}