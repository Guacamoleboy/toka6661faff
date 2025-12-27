package dk.project.controller.review;

// Imports
import dk.project.server.ThymeleafSetup;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class ReviewController {

    // Attributes

    // _______________________________________________

    public static void registerRoutes(Javalin app) {

        app.get("/review-product", ctx -> {
            if (!requireAuthAndProduct(ctx)) return;
            ctx.html(ThymeleafSetup.render("product-review.html", null));
        });

    }

    private static boolean requireAuthAndProduct(Context ctx) {

        Integer userId = ctx.sessionAttribute("userId");
        Object product = ctx.sessionAttribute("currentProduct");

        if (userId == null || product == null) {
            ctx.redirect("/?error=noAccess");
            return false;
        }

        return true;
    }

} // ReviewController end