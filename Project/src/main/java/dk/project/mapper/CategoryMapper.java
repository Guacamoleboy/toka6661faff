// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.Category;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    // Attributes

    // _______________________________________________________________

    public void create(Category category) throws DatabaseException {
        String sql = "INSERT INTO category (name, description) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    category.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette kategori", e);
        }
    }

    // _______________________________________________________________

    public Category getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM category WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Category(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente kategori", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<Category> getAll() throws DatabaseException {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente kategorier", e);
        }

        return categories;
    }

    // _______________________________________________________________

    public void update(Category category) throws DatabaseException {
        String sql = "UPDATE category SET name = ?, description = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke opdatere kategori", e);
        }
    }

    // _______________________________________________________________

    public void delete(int id) throws DatabaseException {
        String sql = "DELETE FROM category WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke slette kategori", e);
        }
    }

}