// Package
package dk.project.server;

// Imports
import dk.project.config.PathingConfig;
import dk.project.server.routing.Routing;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Server {

    // Attributes
    private Javalin app;
    private final PathingConfig pathingConfig = new PathingConfig();

    // _______________________________________________

    public void start(int port) {

        // Static Files
        app = Javalin.create(config -> {

            // Static files
            config.staticFiles.add(staticFiles -> {
                staticFiles.location = Location.CLASSPATH;
                staticFiles.directory = "/static";
            });

            if(pathingConfig.getDeployment()) {
                config.staticFiles.add(staticFiles -> {
                    staticFiles.directory = "content";
                    staticFiles.hostedPath = "/content";
                    staticFiles.location = Location.EXTERNAL;
                });
            }


        }).start(port);

        // Routing
        Routing.registerRoutes(app);

    }

    // _______________________________________________

    public void stop() {
        if (app != null) app.stop();
    }

} // Server end