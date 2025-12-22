// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.ProductInfo;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoMapper {

    // Attributes

    // ________________________________________________________

    public void create(ProductInfo productInfo) throws DatabaseException {
        String sql = "INSERT INTO product_info (name, description) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, productInfo.getName());
            stmt.setString(2, productInfo.getDescription());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    productInfo.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette product info", e);
        }
    }

    // ________________________________________________________

    public ProductInfo getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM product_info WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductInfo(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente product info", e);
        }

        return null;
    }

    // ________________________________________________________

    public List<ProductInfo> getAll() throws DatabaseException {
        List<ProductInfo> list = new ArrayList<>();
        String sql = "SELECT * FROM product_info";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new ProductInfo(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente product info liste", e);
        }

        return list;
    }

    // ________________________________________________________

    public void update(ProductInfo productInfo) throws DatabaseException {
        String sql = "UPDATE product_info SET name = ?, description = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, productInfo.getName());
            stmt.setString(2, productInfo.getDescription());
            stmt.setInt(3, productInfo.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke opdatere product info", e);
        }
    }

    // ________________________________________________________

    public void delete(int id) throws DatabaseException {
        String sql = "DELETE FROM product_info WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke slette product info", e);
        }
    }

}