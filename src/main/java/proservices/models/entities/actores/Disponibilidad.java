package proservices.models.entities.actores;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.Persistente;
import proservices.models.entities.converters.DiaDeSemanaConverter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "disponibilidad")
@Setter
@Getter
public class Disponibilidad extends Persistente {
    @ManyToOne
    @JoinColumn(name = "prestador_id", referencedColumnName = "id")
    private Prestador prestador;
    @Convert(converter = DiaDeSemanaConverter.class)
    @Column(name = "dia")
    private DayOfWeek dia;

    @Column(name = "horaInicio", columnDefinition = "TIME")
    private LocalTime horaInicio;

    @Column(name = "horaFin", columnDefinition = "TIME")
    private LocalTime horaFin;
}
