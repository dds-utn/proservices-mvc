package proservices.server.middlewares;

import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import proservices.models.entities.usuarios.TipoRol;
import proservices.server.exceptions.AccessDeniedException;

public class AuthMiddleware {

    public static void apply(JavalinConfig config) {
        config.accessManager(((handler, context, routeRoles) -> {
            TipoRol userRole = getUserRoleType(context);

            if(routeRoles.size() == 0 || routeRoles.contains(userRole)) {
                handler.handle(context);
            }
            else {
                throw new AccessDeniedException();
            }
        }));
    }

    private static TipoRol getUserRoleType(Context context) {
        return context.cookie("tipo_rol") != null?
                TipoRol.valueOf(context.cookie("tipo_rol")) : null;
    }
}
