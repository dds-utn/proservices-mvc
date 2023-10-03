package proservices.controllers;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import proservices.models.entities.usuarios.Usuario;

public abstract class Controller implements WithSimplePersistenceUnit {

    protected Usuario usuarioLogueado(Context ctx) {
        if(ctx.cookie("usuario_id") == null)
            return null;
        return entityManager()
                .find(Usuario.class, Long.parseLong(ctx.cookie("usuario_id")));
    }
}
