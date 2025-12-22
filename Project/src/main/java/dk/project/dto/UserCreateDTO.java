// Imports
package dk.project.dto;

public class UserCreateDTO {

    // Attributes
    private String username;
    private String email;
    private String password;

    // ____________________________________________________________________

    public UserCreateDTO() {
    }

    // ____________________________________________________________________

    public UserCreateDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // ____________________________________________________________________

    public String getUsername() {
        return username;
    }

    // ____________________________________________________________________

    public void setUsername(String username) {
        this.username = username;
    }

    // ____________________________________________________________________

    public String getEmail() {
        return email;
    }

    // ____________________________________________________________________

    public void setEmail(String email) {
        this.email = email;
    }

    // ____________________________________________________________________

    public String getPassword() {
        return password;
    }

    // ____________________________________________________________________

    public void setPassword(String password) {
        this.password = password;
    }

}