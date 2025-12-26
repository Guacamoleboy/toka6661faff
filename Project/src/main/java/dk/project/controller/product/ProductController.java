// Packages
package dk.project.controller.product;

// Imports
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

            // Session + Validation
            Product product = ctx.sessionAttribute("currentProduct");
            if (product == null) {
                ctx.redirect("/?error=noProductSelected");
                return;
            }

            // Setup
            CategoryMapper categoryMapper = new CategoryMapper();
            SubCategoryMapper subcategoryMapper = new SubCategoryMapper();
            ProductBadgeMapper pbMapper = new ProductBadgeMapper();
            BadgeDefinitionMapper bdMapper = new BadgeDefinitionMapper();

            // Badges
            List<ProductBadge> productBadges = pbMapper.getByProductBarcode(product.getBarcode());
            List<BadgeDefinition> badges = new ArrayList<>();
            for (ProductBadge pb : productBadges) {
                BadgeDefinition bd = bdMapper.getById(pb.getBadgeId());
                if (bd != null) {
                    badges.add(bd);
                }
            }

            // Get category information
            String categoryName = categoryMapper.getById(product.getCategoryId()).getName();
            String subcategoryName = subcategoryMapper.getById(product.getSubcategoryId()).getName();

            Map<String, Object> model = new HashMap<>();
            model.put("product", product);
            model.put("badges", badges);
            model.put("categoryName", categoryName);
            model.put("subcategoryName", subcategoryName);

            ctx.html(ThymeleafSetup.render("product.html", model));

        });

    }

} // ProductController end