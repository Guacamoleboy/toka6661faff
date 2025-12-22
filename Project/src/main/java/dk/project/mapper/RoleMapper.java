// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.Role;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleMapper {

    // Attributes

    // _______________________________________________________________

    public void create(Role role) throws DatabaseException {
        String sql = "INSERT INTO role (name) VALUES (?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, role.getName());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    role.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette rolle", e);
        }
    }

    // _______________________________________________________________

    public Role getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM role WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Role(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente rolle", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<Role> getAll() throws DatabaseException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                roles.add(new Role(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente roller", e);
        }

        return roles;
    }

}