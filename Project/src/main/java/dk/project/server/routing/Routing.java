package dk.project.server.routing;

// Imports
import dk.project.controller.PageController;
import dk.project.controller.auth.AuthController;
import dk.project.controller.scan.ScannerController;
import dk.project.controller.search.InputController;
import io.javalin.Javalin;

public class Routing {

    // Attributes

    // _________________________________________________

    public static void registerRoutes(Javalin app) {

        PageController.registerRoutes(app);
        ScannerController.registerRoutes(app);
        InputController.registerRoutes(app);
        AuthController.registerRoutes(app);

    }

} // Routing end