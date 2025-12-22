// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.User;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    // Attributes

    //  __________________________________________________

    public void create(User user) throws DatabaseException {
        String sql = """
            INSERT INTO users (username_hashed, email_hashed, password_hash, role_id, created_at)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUsernameHashed());
            stmt.setString(2, user.getEmailHashed());
            stmt.setString(3, user.getPasswordHash());
            stmt.setInt(4, user.getRoleId());
            stmt.setTimestamp(5, Timestamp.valueOf(user.getCreatedAt()));
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    user.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette bruger", e);
        }
    }

    //  __________________________________________________

    public User getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username_hashed"),
                            rs.getString("email_hashed"),
                            rs.getString("password_hash"),
                            rs.getInt("role_id"),
                            rs.getTimestamp("created_at").toLocalDateTime()
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente bruger", e);
        }

        return null;
    }

    //  __________________________________________________

    public List<User> getAll() throws DatabaseException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username_hashed"),
                        rs.getString("email_hashed"),
                        rs.getString("password_hash"),
                        rs.getInt("role_id"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente brugere", e);
        }

        return users;
    }

}