package proservices.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.actores.Prestador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio_ofrecido")
@Setter
@Getter
public class ServicioOfrecido {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prestador_id", referencedColumnName = "id")
    private Prestador prestador;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    @Column(name = "radioCobertura")
    private double radioCobertura;

    @Column(name = "experencias", columnDefinition = "longtext")
    private String experiencias;

    @ElementCollection
    @CollectionTable(name = "servicio_ofrecido_foto", joinColumns = @JoinColumn(name = "servicioOfrecido_id"))
    @Column(name = "ruta")
    private List<String> fotos;

    @ManyToMany
    private List<Tarea> tareas;

    public ServicioOfrecido() {
        this.fotos = new ArrayList<>();
        this.tareas = new ArrayList<>();
    }
}
