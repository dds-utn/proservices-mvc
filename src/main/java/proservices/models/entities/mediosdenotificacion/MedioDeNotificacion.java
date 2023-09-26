package proservices.models.entities.mediosdenotificacion;

import proservices.models.entities.actores.Prestador;

public interface MedioDeNotificacion {
    void notificar(Prestador prestador, String mensaje);
}
