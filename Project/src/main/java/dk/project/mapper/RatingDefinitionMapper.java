// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.RatingDefinition;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDefinitionMapper {

    // Attributes

    // _______________________________________________________________

    public void create(RatingDefinition ratingDef) throws DatabaseException {
        String sql = "INSERT INTO rating_definition (subcategory_id, label, rating_type) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, ratingDef.getSubcategoryId());
            stmt.setString(2, ratingDef.getLabel());
            stmt.setString(3, ratingDef.getRatingType());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    ratingDef.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette rating definition", e);
        }
    }

    // _______________________________________________________________

    public RatingDefinition getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM rating_definition WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToRatingDefinition(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente rating definition", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<RatingDefinition> getAll() throws DatabaseException {
        List<RatingDefinition> list = new ArrayList<>();
        String sql = "SELECT * FROM rating_definition";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToRatingDefinition(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente rating definitions", e);
        }

        return list;
    }

    // _______________________________________________________________

    public List<RatingDefinition> getBySubcategoryId(int subcategoryId) throws DatabaseException {
        List<RatingDefinition> list = new ArrayList<>();
        String sql = "SELECT * FROM rating_definition WHERE subcategory_id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, subcategoryId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToRatingDefinition(rs));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente rating definitions for subcategory", e);
        }

        return list;
    }

    // _______________________________________________________________

    public RatingDefinition getByLabel(String label, Integer subcategoryId) throws DatabaseException {
        String sql;
        if (subcategoryId != null) {
            sql = "SELECT * FROM rating_definition WHERE label = ? AND subcategory_id = ?";
        } else {
            sql = "SELECT * FROM rating_definition WHERE label = ?";
        }

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, label);
            if (subcategoryId != null) {
                stmt.setInt(2, subcategoryId);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToRatingDefinition(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente rating definition for label", e);
        }

        return null;
    }

    // _______________________________________________________________

    private RatingDefinition mapResultSetToRatingDefinition(ResultSet rs) throws SQLException {
        return new RatingDefinition(
                rs.getInt("id"),
                rs.getInt("subcategory_id"),
                rs.getString("label"),
                rs.getString("rating_type")
        );
    }
}