// Packages
package dk.project.controller.product;

// Imports
import dk.project.dto.CommentDTO;
import dk.project.dto.UIDTO;
import dk.project.entity.BadgeDefinition;
import dk.project.entity.Product;
import dk.project.entity.ProductBadge;
import dk.project.exception.DatabaseException;
import dk.project.mapper.*;
import dk.project.server.ThymeleafSetup;
import io.javalin.Javalin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {

    // Attributes

    // _______________________________________________

    public static void registerRoutes(Javalin app) {

        // _____________________________________________________________________

        app.get("/product/search", ctx -> {

            // Input
            String query = ctx.queryParam("barcode");
            if (query != null) query = query.trim();

            if (query != null && !query.isBlank()) {
                ProductMapper mapper = new ProductMapper();
                Product product = mapper.getByBarcodeOrName(query);

                if (product != null) {
                    ctx.sessionAttribute("currentProduct", product);
                    ctx.redirect("/product");
                    return;
                }
            }

            ctx.redirect("/?error=noProduct");
        });

        // _____________________________________________________________________

        app.get("/product", ctx -> {

            Product sessionProduct = ctx.sessionAttribute("currentProduct");

            if (sessionProduct == null) {
                ctx.redirect("/?error=noProductSelected");
                return;
            }

            UIMapper uiMapper = new UIMapper();
            UIDTO ui = uiMapper.getProductPage(sessionProduct.getBarcode());

            if (ui == null) {
                ctx.redirect("/?error=productNotFound");
                return;
            }

            ctx.html(ThymeleafSetup.render("product.html", Map.of(
                    "product", ui.getProduct(),
                    "categoryName", ui.getCategoryName(),
                    "subcategoryName", ui.getSubcategoryName(),
                    "badges", ui.getBadges(),
                    "ratings", ui.getRatings(),
                    "totalRating", ui.getTotalRating(),
                    "reviewCount", ui.getReviewCount(),
                    "comments", ui.getComments()
            )));
        });

    }

} // ProductController end