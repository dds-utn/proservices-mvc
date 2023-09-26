package proservices.models.entities.trabajos;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.actores.Prestador;

import javax.persistence.*;

@Entity
@Table(name = "calificacion")
@Setter
@Getter
public class Calificacion {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "opinion", columnDefinition = "text")
    private String opinion;

    @Column(name = "puntaje")
    private Integer puntaje;

    @ManyToOne
    @JoinColumn(name = "prestador_id", referencedColumnName = "id")
    private Prestador prestador;
}
