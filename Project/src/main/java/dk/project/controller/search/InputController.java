package dk.project.controller.search;

import dk.project.mapper.ProductMapper;
import dk.project.entity.Product;
import dk.project.exception.DatabaseException;
import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputController {

    private static final ProductMapper productMapper = new ProductMapper();

    public static void registerRoutes(Javalin app) {

        app.get("/input", ctx -> {

            String queryParam = ctx.queryParam("q");
            String query = (queryParam != null ? queryParam : "").toLowerCase().trim();

            if (query.isEmpty()) {
                ctx.json(List.of());
                return;
            }

            try {
                List<Product> allProducts = productMapper.getAll();
                List<Product> filtered = allProducts.stream()
                        .filter(p -> p.getTitle().toLowerCase().contains(query))
                        .collect(Collectors.toList());

                List<Map<String, String>> resultsJson = filtered.stream()
                        .map(p -> Map.of(
                                "title", p.getTitle(),
                                "imagePath", p.getImagePath()
                        ))
                        .collect(Collectors.toList());

                ctx.json(resultsJson);

            } catch (DatabaseException e) {
                ctx.status(500).result("Databasefejl: " + e.getMessage());
            }

        });
    }
}