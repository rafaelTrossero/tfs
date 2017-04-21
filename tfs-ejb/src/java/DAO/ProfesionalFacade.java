/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Profesional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorge
 */
@Stateless
public class ProfesionalFacade extends AbstractFacade<Profesional> implements ProfesionalFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionalFacade() {
        super(Profesional.class);
    }

    @Override
    public Profesional findByDni(Integer dni) throws Exception {

        try {
            Query q = em.createNamedQuery("Profesional.findByDni");

            q.setParameter("DNI", dni);

            return (Profesional) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void activate(Profesional profesional, Boolean bEstado) {

        Query q = em.createNamedQuery("Profesional.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", profesional.getId());

        q.executeUpdate();
    }

    @Override
    public List<Profesional> findAllActivo() {
           try {
            Query q = em.createNamedQuery("Profesional.SelectAll");

            q.setParameter("active", true);

            return (List<Profesional>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean bFindByCuilProfesional(Profesional p, int op) throws Exception {
            Query q = null;

        if (op == 0) {
            //guardar
            q = em.createNamedQuery("Profesional.findByProfesional");

        } else {
            //modificar
            q = em.createNamedQuery("Profesional.findByCuilID");
            q.setParameter("id", p.getId());

        }//fin if

        q.setParameter("cuil", p.getCuil());
        try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    }

}
