// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.BadgeDefinition;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BadgeDefinitionMapper {

    // _______________________________________________________________

    public void create(BadgeDefinition badge) throws DatabaseException {
        String sql = "INSERT INTO badge_definition (code, label) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, badge.getCode());
            stmt.setString(2, badge.getLabel());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    badge.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette badge definition", e);
        }
    }

    // _______________________________________________________________

    public BadgeDefinition getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM badge_definition WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBadgeDefinition(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente badge definition", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<BadgeDefinition> getAll() throws DatabaseException {
        List<BadgeDefinition> list = new ArrayList<>();
        String sql = "SELECT * FROM badge_definition";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToBadgeDefinition(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente badge definitions", e);
        }

        return list;
    }

    // _______________________________________________________________

    public BadgeDefinition getByCode(String code) throws DatabaseException {
        String sql = "SELECT * FROM badge_definition WHERE code = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, code);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBadgeDefinition(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente badge definition for code", e);
        }

        return null;
    }

    // _______________________________________________________________

    public BadgeDefinition getByLabel(String label) throws DatabaseException {
        String sql = "SELECT * FROM badge_definition WHERE label = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, label);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBadgeDefinition(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente badge definition for label", e);
        }

        return null;
    }

    // _______________________________________________________________

    public void deleteById(int id) throws DatabaseException {
        String sql = "DELETE FROM badge_definition WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke slette badge definition", e);
        }
    }

    // _______________________________________________________________

    private BadgeDefinition mapResultSetToBadgeDefinition(ResultSet rs) throws SQLException {
        return new BadgeDefinition(
                rs.getInt("id"),
                rs.getString("code"),
                rs.getString("label")
        );
    }

}