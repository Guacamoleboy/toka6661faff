// Package
package dk.project.controller.auth;

// Imports
import dk.project.server.ThymeleafSetup;
import io.javalin.Javalin;

public class AuthController {

    // Attributes

    // _______________________________________________

    public static void registerRoutes(Javalin app) {

        app.get("/login", ctx -> ctx.html(ThymeleafSetup.render("login.html", null)));
        app.get("/register", ctx -> ctx.html(ThymeleafSetup.render("register.html", null)));


    }

} // PageController end