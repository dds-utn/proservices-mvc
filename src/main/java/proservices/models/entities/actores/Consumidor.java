package proservices.models.entities.actores;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "consumidor")
@Setter
@Getter
public class Consumidor extends Persistente {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
}
