package proservices.controllers;

import io.javalin.http.Context;
import proservices.models.entities.servicios.Servicio;
import proservices.models.repositories.RepositorioDeServicios;
import proservices.server.utils.ICrudViewsHandler;

import java.util.HashMap;
import java.util.Map;

public class TareasController implements ICrudViewsHandler  {
    private RepositorioDeServicios repositorioDeServicios;

    public TareasController(RepositorioDeServicios repositorioDeServicios) {
        this.repositorioDeServicios = repositorioDeServicios;
    }

    @Override
    public void index(Context context) {
        Servicio servicio = (Servicio) this.repositorioDeServicios.buscar(Long.parseLong(context.pathParam("id")));
        Map<String, Object> model = new HashMap<>();
        model.put("servicio", servicio);
        model.put("tareas", servicio.getTareas());
        context.render("servicios/tareas/tareas.hbs", model);
    }

    @Override
    public void show(Context context) {
        //TODO
    }

    public void create(Context context) {
        //TODO
    }

    @Override
    public void save(Context context) {
        //TODO
    }

    @Override
    public void edit(Context context) {
        //TODO
    }

    @Override
    public void update(Context context) {
        //TODO
    }

    @Override
    public void delete(Context context) {
        //TODO
    }
}
