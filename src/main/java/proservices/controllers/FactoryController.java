package proservices.controllers;

import proservices.models.repositories.RepositorioDeServicios;

public class FactoryController {

    public static Object controller(String nombre) {
        Object controller = null;
        switch (nombre) {
            case "Servicios": controller = new ServiciosController(new RepositorioDeServicios()); break;
            case "Tareas": controller = new TareasController(new RepositorioDeServicios()); break;
        }
        return controller;
    }
}
