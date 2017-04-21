/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Alumno;
import entidad.Pais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno> implements AlumnoFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }

    @Override
    public Alumno findByAlumno(Integer matricula) throws Exception {
try {
            Query q = em.createNamedQuery("Alumno.findByAlumno");

            q.setParameter("MATRICULA", matricula);
           
            return (Alumno) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void activate(Alumno alu, Boolean bEstado) {
  Query q = em.createNamedQuery("Alumno.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", alu.getId());
        // Query q = em.createQuery("UPDATE Agenda p SET p.habilitado = " + estado + " WHERE p.id = " +  id);    
         /*q.setParameter("id", id);
         q.setParameter("estado", estado);  */
        q.executeUpdate();
    
    }

    @Override
    public Boolean bFindByDni(Alumno p, int op) throws Exception {
    
        Query q = null;

        if (op == 0) {
            //guardar
            q = em.createNamedQuery("Alumno.findByDni");

        } else {
            //modificar
            q = em.createNamedQuery("Alumno.findByDniID");
            q.setParameter("id", p.getId());
            

        }//fin if

        q.setParameter("dni", p.getDni());

        try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    
    }

    @Override
    public Boolean bFindByUserName(Alumno p, int op) throws Exception {
     Query q = null;

        if (op == 0) {
            //guardar
            q = em.createNamedQuery("Alumno.findByNameUserID");

        } else {
            //modificar
            q = em.createNamedQuery("Alumno.findByNameUser");
            q.setParameter("id", p.getId());
            

        }//fin if

        q.setParameter("userName", p.getUsername());

        try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    
    }
    
    
}
