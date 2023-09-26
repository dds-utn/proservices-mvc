package proservices.models.entities.actores;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.Persistente;
import proservices.models.entities.actores.reputaciones.Reputacion;
import proservices.models.entities.actores.reputaciones.ReputacionBuena;
import proservices.models.entities.converters.MedioDeNotificacionAttributeConverter;
import proservices.models.entities.mediosdenotificacion.MedioDeNotificacion;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "prestador")
@Setter
@Getter
public class Prestador extends Persistente {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "foto")
    private String foto;

    @Column(name = "nroDocumento")
    private String nroDocumento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDocumento")
    private TipoDocumento tipoDocumento;

    @Column(name = "fechaNacimiento", columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @Column(name = "cuitCuil")
    private String cuitCuil;

    @ElementCollection
    @CollectionTable(name = "prestador_email", joinColumns = @JoinColumn(name = "prestador_id"))
    @Column(name = "email")
    private Set<String> emails;

    @ElementCollection
    @CollectionTable(name = "prestador_telefono", joinColumns = @JoinColumn(name = "prestador_id"))
    @Column(name = "telefono")
    private Set<String> telefonos;

    @OneToMany(mappedBy = "prestador", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Disponibilidad> disponibilidades;

    @OneToOne
    @JoinColumn(name = "reputacion_id", referencedColumnName = "id")
    private Reputacion reputacion;

    @Convert(converter = MedioDeNotificacionAttributeConverter.class)
    @Column(name = "medioDeNotificacion")
    private MedioDeNotificacion medioDeNotificacion;

    @OneToMany
    private List<Prestador> prestadores;

    public Prestador() {
        this.emails = new HashSet<>();
        this.telefonos = new HashSet<>();
        this.disponibilidades = new ArrayList<>();
        this.reputacion = new ReputacionBuena();
    }

    public void agregarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidades.add(disponibilidad);
        disponibilidad.setPrestador(this);
    }
}
