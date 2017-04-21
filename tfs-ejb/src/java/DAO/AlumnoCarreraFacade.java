/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Alumno;
import entidad.AlumnoCarrera;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class AlumnoCarreraFacade extends AbstractFacade<AlumnoCarrera> implements AlumnoCarreraFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoCarreraFacade() {
        super(AlumnoCarrera.class);
    }

    @Override
    public AlumnoCarrera findByAlumno(AlumnoCarrera alu) throws Exception {
        try {
            Query q = em.createNamedQuery("AlumnoCarrera.findByAlumnoCarrera");

            q.setParameter("aluID", alu.getAlumno());

            return (AlumnoCarrera) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public AlumnoCarrera findByAlumnoCarrera(Long idAlu, Long idCar) throws Exception {
        try {
            Query q = em.createNamedQuery("AlumnoCarrera.findByCodigoCarrera");

            q.setParameter("aluId", idAlu);
            q.setParameter("carId", idCar);

            return (AlumnoCarrera) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<AlumnoCarrera> findAlumnoCarrera(AlumnoCarrera alu_car) throws Exception {
        Query query = null;
        String q = "SELECT u FROM AlumnoCarrera u WHERE u.id =:id ";
        //      + "AND NOT EXISTS (SELECT us FROM Users us JOIN u.projectUserLst p WHERE p.project =:project)";
 query.setParameter("id", alu_car.getId());
        query = em.createQuery(q);

        //query.setParameter("id", alu_car.getId());

        //query.setParameter("project", project);
        return query.getResultList();

    }

}
