package proservices.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tarea")
@Setter
@Getter
public class Tarea {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;
}
