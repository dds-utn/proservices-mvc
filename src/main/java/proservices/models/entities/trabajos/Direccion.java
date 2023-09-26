package proservices.models.entities.trabajos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Direccion {
    @Column
    private String calle;
    @Column
    private String altura;
    @Column
    private String piso;
    @Column
    private String depto;
    @Column
    private String cp;
    @Column
    private String referencia;
    @Column
    private String barrio;
    @Column
    private String provincia;
}
