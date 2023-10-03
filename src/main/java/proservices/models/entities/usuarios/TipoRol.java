package proservices.models.entities.usuarios;

import io.javalin.security.RouteRole;

public enum TipoRol implements RouteRole {
    ADMINISTRADOR,
    NORMAL,
}
