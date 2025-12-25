package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.SubCategory;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryMapper {

    // Attributes

    // _______________________________________________________________

    public void create(SubCategory subCategory) throws DatabaseException {
        String sql = "INSERT INTO subcategory (category_id, name, description) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, subCategory.getCategoryId());
            stmt.setString(2, subCategory.getName());
            stmt.setString(3, subCategory.getDescription());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    subCategory.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette subkategori", e);
        }
    }

    // _______________________________________________________________

    public SubCategory getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM subcategory WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SubCategory(
                            rs.getInt("id"),
                            rs.getInt("category_id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente subkategori", e);
        }

        return null;
    }

    // _______________________________________________________________

    public SubCategory getByName(String name, Integer categoryId) throws DatabaseException {
        String sql;
        if (categoryId != null) {
            sql = "SELECT * FROM subcategory WHERE name = ? AND category_id = ?";
        } else {
            sql = "SELECT * FROM subcategory WHERE name = ?";
        }

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            if (categoryId != null) {
                stmt.setInt(2, categoryId);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SubCategory(
                            rs.getInt("id"),
                            rs.getInt("category_id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente subkategori efter navn", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<SubCategory> getAll() throws DatabaseException {
        List<SubCategory> subCategories = new ArrayList<>();
        String sql = "SELECT * FROM subcategory";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                subCategories.add(new SubCategory(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente subkategorier", e);
        }

        return subCategories;
    }

    // _______________________________________________________________

    public List<SubCategory> getByCategoryId(int categoryId) throws DatabaseException {
        List<SubCategory> subCategories = new ArrayList<>();
        String sql = "SELECT * FROM subcategory WHERE category_id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, categoryId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    subCategories.add(new SubCategory(
                            rs.getInt("id"),
                            rs.getInt("category_id"),
                            rs.getString("name"),
                            rs.getString("description")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente subkategorier for kategori", e);
        }

        return subCategories;
    }
}