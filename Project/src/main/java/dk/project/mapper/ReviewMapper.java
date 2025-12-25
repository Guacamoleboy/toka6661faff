// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.Review;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {

    // Attributes

    // _______________________________________________________________

    public void create(Review review) throws DatabaseException {
        String sql = "INSERT INTO review (product_barcode, user_id, final_comment, created_at) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, review.getProductBarcode());
            stmt.setInt(2, review.getUserId());
            stmt.setString(3, review.getFinalComment());
            stmt.setTimestamp(4, Timestamp.valueOf(review.getCreatedAt()));

            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    review.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette review", e);
        }
    }

    // _______________________________________________________________

    public Review getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM review WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToReview(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente review", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<Review> getAll() throws DatabaseException {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reviews.add(mapResultSetToReview(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente reviews", e);
        }

        return reviews;
    }

    // _______________________________________________________________

    public List<Review> getByProductBarcode(String barcode) throws DatabaseException {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE product_barcode = ? ORDER BY created_at DESC";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barcode);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reviews.add(mapResultSetToReview(rs));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente reviews for produkt", e);
        }

        return reviews;
    }

    // _______________________________________________________________

    public List<Review> getByUserId(int userId) throws DatabaseException {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE user_id = ? ORDER BY created_at DESC";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reviews.add(mapResultSetToReview(rs));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente reviews for bruger", e);
        }

        return reviews;
    }

    // _______________________________________________________________

    private Review mapResultSetToReview(ResultSet rs) throws SQLException {
        return new Review(
                rs.getInt("id"),
                rs.getString("product_barcode"),
                rs.getInt("user_id"),
                rs.getString("final_comment"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }

}