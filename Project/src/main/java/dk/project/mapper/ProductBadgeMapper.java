// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.ProductBadge;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductBadgeMapper {

    // Attributes

    // _______________________________________________________________

    public void create(ProductBadge badge) throws DatabaseException {
        String sql = "INSERT INTO product_badge (product_barcode, badge_id) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, badge.getProductBarcode());
            stmt.setInt(2, badge.getBadgeId());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    badge.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette product badge", e);
        }
    }

    // _______________________________________________________________

    public ProductBadge getById(int id) throws DatabaseException {
        String sql = "SELECT * FROM product_badge WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProductBadge(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente product badge", e);
        }

        return null;
    }

    // _______________________________________________________________

    public List<ProductBadge> getAll() throws DatabaseException {
        List<ProductBadge> list = new ArrayList<>();
        String sql = "SELECT * FROM product_badge";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToProductBadge(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente product badges", e);
        }

        return list;
    }

    // _______________________________________________________________

    public List<ProductBadge> getByProductBarcode(String barcode) throws DatabaseException {
        List<ProductBadge> list = new ArrayList<>();
        String sql = "SELECT * FROM product_badge WHERE product_barcode = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barcode);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToProductBadge(rs));
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente badges for produkt", e);
        }

        return list;
    }

    // _______________________________________________________________

    public void deleteById(int id) throws DatabaseException {
        String sql = "DELETE FROM product_badge WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke slette product badge", e);
        }
    }

    // _______________________________________________________________

    private ProductBadge mapResultSetToProductBadge(ResultSet rs) throws SQLException {
        return new ProductBadge(
                rs.getInt("id"),
                rs.getString("product_barcode"),
                rs.getInt("badge_id"),
                rs.getTimestamp("added").toLocalDateTime()
        );
    }

}