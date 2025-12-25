// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.ReviewRating;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRatingMapper {

    // Attributes

    // _______________________________________________________________

    public void create(ReviewRating rating) throws DatabaseException {
        String sql = "INSERT INTO review_rating (review_id, rating_definition_id, value, comment) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, rating.getReviewId());
            stmt.setInt(2, rating.getRatingDefinitionId());
            stmt.setDouble(3, rating.getValue());
            stmt.setString(4, rating.getComment());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    rating.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette review rating", e);
        }
    }

    // _______________________________________________________________

    public ReviewRating getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM review_rating WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ReviewRating(
                            rs.getInt("id"),
                            rs.getInt("review_id"),
                            rs.getInt("rating_definition_id"),
                            rs.getDouble("value"),
                            rs.getString("comment")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente review rating", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<ReviewRating> getAll() throws DatabaseException {
        List<ReviewRating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM review_rating";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ratings.add(new ReviewRating(
                        rs.getInt("id"),
                        rs.getInt("review_id"),
                        rs.getInt("rating_definition_id"),
                        rs.getDouble("value"),
                        rs.getString("comment")
                ));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente review ratings", e);
        }

        return ratings;
    }

    // _______________________________________________________________

    public List<ReviewRating> getByReviewId(int reviewId) throws DatabaseException {
        List<ReviewRating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM review_rating WHERE review_id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reviewId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ratings.add(new ReviewRating(
                            rs.getInt("id"),
                            rs.getInt("review_id"),
                            rs.getInt("rating_definition_id"),
                            rs.getDouble("value"),
                            rs.getString("comment")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente review ratings for review", e);
        }

        return ratings;
    }

    // _______________________________________________________________

    public ReviewRating getByReviewAndDefinition(int reviewId, int ratingDefinitionId) throws DatabaseException {
        String sql = "SELECT * FROM review_rating WHERE review_id = ? AND rating_definition_id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reviewId);
            stmt.setInt(2, ratingDefinitionId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ReviewRating(
                            rs.getInt("id"),
                            rs.getInt("review_id"),
                            rs.getInt("rating_definition_id"),
                            rs.getDouble("value"),
                            rs.getString("comment")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente review rating for review + definition", e);
        }

        return null;
    }
}