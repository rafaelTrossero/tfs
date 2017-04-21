/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoTribunal;
import entidad.Proyecto;
import entidad.Tribunal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Trossero
 */
@Stateless
public class ProyectoTribunalFacade extends AbstractFacade<ProyectoTribunal> implements ProyectoTribunalFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoTribunalFacade() {
        super(ProyectoTribunal.class);
    }

    @Override
    public Tribunal findTribunal(Proyecto proyecto, Boolean active) {
        try {
            Query q = em.createNamedQuery("Proy_tribunal.findTribunal");

            q.setParameter("proyecto", proyecto);
             q.setParameter("active", active);
            
           
            return (Tribunal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Proyecto findProyectoByTribunal(long tribunal) throws Exception {
         try {
            Query q = em.createNamedQuery("Proy_tribunal.findProyectoByTribunal");

            q.setParameter("tribunal", tribunal);
             q.setParameter("active", true);
            
           
            return (Proyecto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
