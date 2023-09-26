package proservices.models.main;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import proservices.models.entities.servicios.Servicio;
import proservices.models.entities.servicios.Tarea;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MainExample implements WithSimplePersistenceUnit {

    public static void main(String[] args) {
        new MainExample().start();
    }

    private void start() {

    }

    private void recuperarServicioPorCriteriaBuilder() {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();

        CriteriaQuery<Servicio> criteriaQuery = cb.createQuery(Servicio.class);

        Root<Servicio> root = criteriaQuery.from(Servicio.class);

        criteriaQuery
                .select(root)//SELECT  * FROM servicio
                .where(
                        cb.and(
                                cb.like(root.get("nombre"), "%dine%"),
                                cb.between(root.get("id"), 1L, 3L)
                        )
                );// WHERE nombre LIKE '%dine%' AND id between (1,3)

        List serviciosBuscados = entityManager()
                .createQuery(criteriaQuery)
                .getResultList();

        System.out.println(serviciosBuscados);
    }

    private void recuperarServicioPorNombreEnQuery() {
        Servicio jardineria = (Servicio) entityManager()
                .createQuery("from " + Servicio.class.getName() + " where nombre = :nombre")
                .setParameter("nombre", "Jardinería")
                .getSingleResult();
    }

    private void recuperarServicioPorId() {
        Servicio servicioDeJardineria = (Servicio) entityManager().find(Servicio.class, 2L);

        System.out.println(servicioDeJardineria.getNombre());

        System.out.println(servicioDeJardineria.cantTareas());
    }

    private void guardarServicioJardineria() {
        Servicio jardineria = new Servicio();
        jardineria.setNombre("Jardinería");

        Tarea unaTarea = new Tarea();
        unaTarea.setNombre("Podar arboles");

        Tarea otraTarea = new Tarea();
        otraTarea.setNombre("Cortar el pasto");

        jardineria.agregarTarea(unaTarea);
        jardineria.agregarTarea(otraTarea);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().persist(jardineria);

        tx.commit();
    }
}
