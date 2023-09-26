package proservices.models.entities;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persistente {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
}
