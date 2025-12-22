// Package
package dk.project.dto;

public class UserResponseDTO {

    // Attributes
    private int id;
    private String username;
    private String role;

    // _____________________________________________________________

    public UserResponseDTO() {
    }

    // _____________________________________________________________

    public UserResponseDTO(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    // _____________________________________________________________

    public void setUsername(String username) {
        this.username = username;
    }

    // _____________________________________________________________

    public String getRole() {
        return role;
    }

    // _____________________________________________________________

    public void setRole(String role) {
        this.role = role;
    }

}