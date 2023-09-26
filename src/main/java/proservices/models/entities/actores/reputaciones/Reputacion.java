package proservices.models.entities.actores.reputaciones;

import proservices.models.entities.Persistente;
import proservices.models.entities.actores.Prestador;
import proservices.models.entities.trabajos.Calificacion;
import proservices.models.entities.trabajos.Trabajo;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Reputacion extends Persistente {
    @Column
    private String direccion;

    public abstract void serContratado(Trabajo trabajo, Prestador prestador);

    public abstract void recibirCalificacion(Calificacion calificacion, Prestador prestador);
}
