// Package
package dk.project.dto;

// Imports
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CommentDTO {

    // Attributes
    private final int id;
    private final String author;
    private final String text;
    private final LocalDateTime createdAt;
    private final double rating;

    // _____________________________________________________________________________

    public CommentDTO(int id, String author, String text, LocalDateTime createdAt, double rating) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.createdAt = createdAt;
        this.rating = rating;
    }

    // _____________________________________________________________________________

    public int getId() {
        return id;
    }

    // _____________________________________________________________________________

    public String getAuthor() {
        return author;
    }

    // _____________________________________________________________________________

    public String getText() {
        return text;
    }

    // _____________________________________________________________________________

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // _____________________________________________________________________________

    public double getRating() {
        return rating;
    }

}