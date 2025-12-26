// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.entity.Product;
import dk.project.entity.ProductInfo;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    // Attributes

    // _________________________________________________________

    public void create(Product product) throws DatabaseException {
        String sql = """
            INSERT INTO product (barcode, product_info_id, category_id, subcategory_id, image_path, created_at)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getBarcode());
            stmt.setInt(2, product.getProductInfo().getId());
            stmt.setInt(3, product.getCategoryId());
            stmt.setInt(4, product.getSubcategoryId());
            stmt.setString(5, product.getImagePath());
            stmt.setTimestamp(6, Timestamp.valueOf(product.getCreatedAt()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke oprette produkt", e);
        }
    }

    // _________________________________________________________

    public Product getByBarcode(String barcode) throws DatabaseException {
        String sql = """
            SELECT p.*, pi.name AS product_name, pi.description AS product_description
            FROM product p
            JOIN product_info pi ON p.product_info_id = pi.id
            WHERE p.barcode = ?
            """;

        return mapSingleProduct(barcode, sql, true);
    }

    // _________________________________________________________

    public List<Product> getAll() throws DatabaseException {
        List<Product> products = new ArrayList<>();
        String sql = """
            SELECT p.*, pi.name AS product_name, pi.description AS product_description
            FROM product p
            JOIN product_info pi ON p.product_info_id = pi.id
            """;

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente produkter", e);
        }

        return products;
    }

    // _________________________________________________________

    public Product getByBarcodeOrName(String input) throws DatabaseException {
        String sql = """
            SELECT p.*, pi.name AS product_name, pi.description AS product_description
            FROM product p
            JOIN product_info pi ON p.product_info_id = pi.id
            WHERE p.barcode = ? OR LOWER(pi.name) = LOWER(?)
            LIMIT 1
            """;

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, input);
            stmt.setString(2, input);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProduct(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente produkt", e);
        }

        return null;
    }

    // _________________________________________________________

    public void delete(String barcode) throws DatabaseException {
        String sql = "DELETE FROM product WHERE barcode = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barcode);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke slette produkt", e);
        }
    }

    // _________________________________________________________

    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        ProductInfo productinfo = new ProductInfo();
        productinfo.setId(rs.getInt("product_info_id"));
        productinfo.setName(rs.getString("product_name"));
        productinfo.setDescription(rs.getString("product_description"));

        return new Product(
                rs.getString("barcode"),
                rs.getString("product_name"),
                productinfo,
                rs.getInt("category_id"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getString("image_path"),
                rs.getInt("subcategory_id")
        );
    }

    // _________________________________________________________

    private Product mapSingleProduct(String param, String sql, boolean byBarcode) throws DatabaseException {
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, param);
            if (!byBarcode) {
                stmt.setString(2, param);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProduct(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente produkt", e);
        }
        return null;
    }

}