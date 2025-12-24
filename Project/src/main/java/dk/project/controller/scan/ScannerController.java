package dk.project.controller.scan;

// Imports
import dk.project.dto.BarcodeRequest;
import io.javalin.Javalin;

public class ScannerController {

    // Attributes

    // _______________________________________________

    public static void registerRoutes(Javalin app) {

        app.post("/barcode", ctx -> {

            String ean = ctx.bodyAsClass(BarcodeRequest.class).ean;
            System.out.println("Scannet EAN: " + ean);

            ctx.status(200);
        });

    }

} // ScannerController end