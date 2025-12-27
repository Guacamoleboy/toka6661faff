// Package
package dk.project.controller.auth;

// Imports
import dk.project.entity.User;
import dk.project.exception.DatabaseException;
import dk.project.mapper.UserMapper;
import dk.project.server.ThymeleafSetup;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.apache.commons.codec.digest.DigestUtils;
import org.mindrot.jbcrypt.BCrypt;
import java.util.HashMap;
import java.util.Map;

public class AuthController {

    // Attributes

    // _______________________________________________

    public static void registerRoutes(Javalin app) {

        app.get("/login", ctx -> {
            redirectIfLoggedIn(ctx, "alreadyLI");
            if (ctx.res().isCommitted()) return;
            ctx.html(ThymeleafSetup.render("login.html", null));
        });

        // _______________________________________________

        app.get("/register", ctx -> {
            redirectIfLoggedIn(ctx, "logOutFirst");
            if (ctx.res().isCommitted()) return;
            ctx.html(ThymeleafSetup.render("register.html", null));
        });

        // _______________________________________________

        app.get("/logout", ctx -> {
            ctx.sessionAttribute("userId", null);
            ctx.sessionAttribute("username", null);
            ctx.redirect("/?success=loggedOut");
        });

        // _______________________________________________

        app.get("/api/session/user", ctx -> {
            Integer userId = ctx.sessionAttribute("userId");
            if (userId != null) {
                UserMapper userMapper = new UserMapper();
                try {
                    User user = userMapper.getById(userId);
                    if (user != null) {
                        ctx.json(Map.of(
                                "loggedIn", true,
                                "username", user.getUsername(),
                                "roleId", user.getRoleId()
                        ));
                        return;
                    }
                } catch (DatabaseException e) {
                    ctx.status(500).json(Map.of("loggedIn", false));
                    return;
                }
            }
            ctx.json(Map.of("loggedIn", false));
        });

        // _______________________________________________

        app.post("/login", ctx -> {

            // Initial
            String email = ctx.formParam("login-email");
            String password = ctx.formParam("login-password");
            String redirectUrl = ctx.formParam("redirect");

            System.out.println(redirectUrl);

            // Checks
            if (email == null || password == null) {
                ctx.redirect("/login?error=missingFields");
                return;
            }

            String hashedEmail = DigestUtils.sha256Hex(email);

            // Setup
            UserMapper userMapper = new UserMapper();
            try {
                User user = userMapper.getByEmail(hashedEmail);
                if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
                    ctx.sessionAttribute("userId", user.getId());
                    if (redirectUrl != null && !redirectUrl.isBlank()) {
                        ctx.redirect(redirectUrl + "?success=loggedIn");
                    } else {
                        ctx.redirect("/?success=loggedIn");
                    }
                } else {
                    ctx.redirect("/login?error=wrongInfo");
                }
            } catch (DatabaseException e) {
                ctx.redirect("/login?error=dbError");
            }

        });

        // _______________________________________________

        app.post("/register", ctx -> {

            // Initial
            String firstname = ctx.formParam("register-firstname");
            String lastname = ctx.formParam("register-lastname");
            String username = ctx.formParam("register-username");
            String email = ctx.formParam("register-email");
            String password = ctx.formParam("register-password");
            String confirmPassword = ctx.formParam("register-password-confirm");
            String redirectUrl = ctx.formParam("redirect");

            // Validation 1
            if (firstname == null || lastname == null || username == null || email == null || password == null || confirmPassword == null) {
                ctx.redirect("/register?error=missingFields");
                return;
            }

            // Validation 2
            if (!password.equals(confirmPassword)) {
                ctx.redirect("/register?error=wrongPassMatch");
                return;
            }

            // Hash (GDPR & Safety)
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            String hashedEmail = DigestUtils.sha256Hex(email);

            // Create user
            User user = new User();
            user.setUsername(username);
            user.setEmailHashed(hashedEmail);
            user.setPasswordHash(hashedPassword);
            user.setRoleId(1);

            UserMapper userMapper = new UserMapper();
            try {
                userMapper.create(user);
                if (redirectUrl != null && !redirectUrl.isBlank()) {
                    ctx.redirect(redirectUrl + "?success=accountCreated");
                } else {
                    ctx.redirect("/?success=accountCreated");
                }
            } catch (DatabaseException e) {
                if (e.getMessage().toLowerCase().contains("unique")) {
                    ctx.redirect("/register?error=accountExists");
                } else {
                    ctx.redirect("/register?error=dbError");
                }
            }
        });

    }

    // _________________________________________________________________________________

    private static void redirectIfLoggedIn(Context ctx, String code) {
        Integer userId = ctx.sessionAttribute("userId");
        if (userId != null) {
            ctx.redirect("/?error=" + code);
        }
    }

} // PageController end