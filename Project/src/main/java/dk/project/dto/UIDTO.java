// Package
package dk.project.dto;

// Imports
import dk.project.entity.BadgeDefinition;
import dk.project.entity.Product;
import java.util.List;

public class UIDTO {

    // Attributes
    private final Product product;
    private final String categoryName;
    private final String subcategoryName;
    private final List<BadgeDefinition> badges;
    private final List<UIRatingDTO> ratings;
    private final double totalRating;
    private final int reviewCount;
    private final List<CommentDTO> comments;

    // _____________________________________________________________________________

    public UIDTO(Product product, String categoryName, String subcategoryName, List<BadgeDefinition> badges, List<UIRatingDTO> ratings, double totalRating, int reviewCount, List<CommentDTO> comments) {
        this.product = product;
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.badges = badges;
        this.ratings = ratings;
        this.totalRating = totalRating;
        this.reviewCount = reviewCount;
        this.comments = comments;
    }

    // _____________________________________________________________________________

    public Product getProduct() {
        return product;
    }

    // _____________________________________________________________________________

    public String getCategoryName() {
        return categoryName;
    }

    // _____________________________________________________________________________

    public String getSubcategoryName() {
        return subcategoryName;
    }

    // _____________________________________________________________________________

    public List<BadgeDefinition> getBadges() {
        return badges;
    }

    // _____________________________________________________________________________

    public List<UIRatingDTO> getRatings() {
        return ratings;
    }

    // _____________________________________________________________________________

    public double getTotalRating() {
        return totalRating;
    }

    // _____________________________________________________________________________

    public int getReviewCount() {
        return reviewCount;
    }

    // _____________________________________________________________________________

    public List<CommentDTO> getComments() {
        return comments;
    }

}