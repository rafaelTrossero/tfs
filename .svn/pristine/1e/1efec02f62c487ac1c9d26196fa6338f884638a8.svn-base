/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Calificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Trossero
 */
@Stateless
public class CalificacionFacade extends AbstractFacade<Calificacion> implements CalificacionFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionFacade() {
        super(Calificacion.class);
    }

    @Override
    public Calificacion findById(Long id) throws Exception {
      
    try {
            Query q = em.createNamedQuery("Calificacion.findById");

            q.setParameter("id", id);
           
            return (Calificacion) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
