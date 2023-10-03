package proservices.models.entities.usuarios;

import lombok.Getter;
import lombok.Setter;
import proservices.models.entities.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Setter
@Getter
public class Usuario extends Persistente {
    @Column(name = "nombreDeUsuario")
    private String nombreDeUsuario;

    @Column(name = "contrasenia")
    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;
}
