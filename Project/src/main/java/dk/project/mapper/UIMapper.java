// Package
package dk.project.mapper;

// Imports
import dk.project.db.Database;
import dk.project.dto.CommentDTO;
import dk.project.dto.RatingSummary;
import dk.project.dto.UIDTO;
import dk.project.dto.UIRatingDTO;
import dk.project.entity.BadgeDefinition;
import dk.project.entity.Product;
import dk.project.entity.ProductInfo;
import dk.project.exception.DatabaseException;
import java.sql.*;
import java.util.*;

public class UIMapper {

    // Attributes

    // ____________________________________________________________________________

    public UIDTO getProductPage(String barcode) throws DatabaseException {

        String sql = """
        SELECT
            p.barcode,         -- 1
            p.image_path,      -- 2
            p.created_at,      -- 3
    
            pi.id,             -- 4
            pi.name,           -- 5
            pi.description,    -- 6
    
            c.name,            -- 7
            sc.name,           -- 8
    
            bd.id,             -- 9
            bd.code,           -- 10
            bd.label           -- 11
    
        FROM product p
        JOIN product_info pi ON p.product_info_id = pi.id
        JOIN category c ON p.category_id = c.id
        JOIN subcategory sc ON p.subcategory_id = sc.id
        LEFT JOIN product_badge pb ON pb.product_barcode = p.barcode
        LEFT JOIN badge_definition bd ON bd.id = pb.badge_id
        WHERE p.barcode = ?
        """;

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barcode);

            try (ResultSet rs = stmt.executeQuery()) {

                Product product = null;
                String categoryName = null;
                String subcategoryName = null;
                Map<Integer, BadgeDefinition> badges = new LinkedHashMap<>();

                while (rs.next()) {

                    if (product == null) {
                        ProductInfo info = new ProductInfo(
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getString(6)
                        );

                        product = new Product(
                                rs.getString(1),
                                rs.getString(5),
                                info,
                                0,
                                rs.getTimestamp(3).toLocalDateTime(),
                                rs.getString(2),
                                0
                        );

                        categoryName = rs.getString(7);
                        subcategoryName = rs.getString(8);
                    }

                    int badgeId = rs.getInt(9);
                    if (!rs.wasNull() && !badges.containsKey(badgeId)) {
                        badges.put(
                                badgeId,
                                new BadgeDefinition(
                                        badgeId,
                                        rs.getString(10),
                                        rs.getString(11)
                                )
                        );
                    }
                }

                if (product == null) return null;

                List<UIRatingDTO> ratings = getRatings(conn, barcode);
                RatingSummary summary = getTotalRating(conn, barcode);
                List<CommentDTO> comments = getComments(conn, barcode);

                return new UIDTO(
                        product,
                        categoryName,
                        subcategoryName,
                        new ArrayList<>(badges.values()),
                        ratings,
                        summary.average(),
                        summary.reviewCount(),
                        comments
                );

            }

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke hente UI data", e);
        }
    }

    // ____________________________________________________________________________

    private List<UIRatingDTO> getRatings(Connection conn, String barcode) throws SQLException {
        String sql = """
        SELECT rd.label, AVG(rr.value)::numeric(2,1)
        FROM review r
        JOIN review_rating rr ON rr.review_id = r.id
        JOIN rating_definition rd ON rd.id = rr.rating_definition_id
        WHERE r.product_barcode = ?
        GROUP BY rd.label
        ORDER BY rd.label
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barcode);

            try (ResultSet rs = stmt.executeQuery()) {
                List<UIRatingDTO> ratings = new ArrayList<>();
                while (rs.next()) {
                    ratings.add(new UIRatingDTO(
                            rs.getString(1),
                            rs.getDouble(2)
                    ));
                }
                return ratings;
            }
        }
    }

    // ____________________________________________________________________________

    private RatingSummary getTotalRating(Connection conn, String barcode) throws SQLException {
        String sql = """
        SELECT COUNT(DISTINCT r.id) AS review_count,
        AVG(rr.value)::numeric(2,1) AS avg_rating
        FROM review r
        JOIN review_rating rr ON rr.review_id = r.id
        WHERE r.product_barcode = ?
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barcode);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int reviewCount = rs.getInt("review_count");
                    double average = rs.getDouble("avg_rating");
                    return new RatingSummary(reviewCount, average);
                }
            }
        }

        return new RatingSummary(0, 0.0);
    }

    // ____________________________________________________________________________

    private List<CommentDTO> getComments(Connection conn, String barcode) throws SQLException {
        String sql = """
        SELECT r.id, u.first_name AS author, r.final_comment AS comment_text, r.created_at,
        ROUND(AVG(rr.value)::numeric, 1) AS avg_rating
        FROM review r
        JOIN users u ON u.id = r.user_id
        LEFT JOIN review_rating rr ON rr.review_id = r.id
        WHERE r.product_barcode = ?
        GROUP BY r.id, u.first_name, r.final_comment, r.created_at
        ORDER BY r.created_at DESC;
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barcode);
            try (ResultSet rs = stmt.executeQuery()) {
                List<CommentDTO> comments = new ArrayList<>();
                while (rs.next()) {
                    comments.add(new CommentDTO(
                            rs.getInt("id"),
                            rs.getString("author"),
                            rs.getString("comment_text"),
                            rs.getTimestamp("created_at").toLocalDateTime(),
                            rs.getDouble("avg_rating")
                    ));
                }
                return comments;
            }
        }
    }


}