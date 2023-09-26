package proservices.models.entities.actores.reputaciones;

import proservices.models.entities.actores.Prestador;
import proservices.models.entities.trabajos.Calificacion;
import proservices.models.entities.trabajos.Trabajo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("buena")
public class ReputacionBuena extends Reputacion {
    @Column
    private String nombre;

    @Override
    public void serContratado(Trabajo trabajo, Prestador prestador) {
        //TODO
    }

    @Override
    public void recibirCalificacion(Calificacion calificacion, Prestador prestador) {
        //TODO
    }
}
