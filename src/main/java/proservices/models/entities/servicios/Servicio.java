package proservices.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio")
public class Servicio extends Persistente {
    @Column(name = "nombre")
    @Getter
    @Setter
    private String nombre;

    @Getter
    @OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private List<Tarea> tareas;

    public Servicio() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea unaTarea) {
        this.tareas.add(unaTarea);
    }

    public int cantTareas() {
        return this.tareas.size();
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "nombre='" + nombre + '\'' +
                ", tareas=" + tareas +
                '}';
    }
}
