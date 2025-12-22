// Package
package dk.project.entity;

// Imports
import java.time.LocalDateTime;

public class User {

    // Attributes
    private int id;
    private String usernameHashed;
    private String emailHashed;
    private String passwordHash;
    private int roleId;
    private LocalDateTime createdAt;

    // ___________________________________________________________

    public User() {
    }

    // ___________________________________________________________

    public User(int id, String usernameHashed, String emailHashed, String passwordHash, int roleId, LocalDateTime createdAt) {
        this.id = id;
        this.usernameHashed = usernameHashed;
        this.emailHashed = emailHashed;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
        this.createdAt = createdAt;
    }

    // ___________________________________________________________

    public User(String usernameHashed, String emailHashed, String passwordHash, int roleId) {
        this.usernameHashed = usernameHashed;
        this.emailHashed = emailHashed;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
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

    public String getUsernameHashed() {
        return usernameHashed;
    }

    // ___________________________________________________________

    public void setUsernameHashed(String usernameHashed) {
        this.usernameHashed = usernameHashed;
    }

    // ___________________________________________________________

    public String getEmailHashed() {
        return emailHashed;
    }

    // ___________________________________________________________

    public void setEmailHashed(String emailHashed) {
        this.emailHashed = emailHashed;
    }

    // ___________________________________________________________

    public String getPasswordHash() {
        return passwordHash;
    }

    // ___________________________________________________________

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // ___________________________________________________________

    public int getRoleId() {
        return roleId;
    }

    // ___________________________________________________________

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    // ___________________________________________________________

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ___________________________________________________________

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}