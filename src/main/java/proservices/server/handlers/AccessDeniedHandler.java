package proservices.server.handlers;

import io.javalin.Javalin;
import proservices.server.exceptions.AccessDeniedException;

public class AccessDeniedHandler implements IHandler {

    @Override
    public void setHandle(Javalin app) {
        app.exception(AccessDeniedException.class, (e, context) -> {
            context.render("401.hbs");
        });
    }
}
