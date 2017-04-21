/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Objetivos;
import entidad.Proyecto;
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
public class ObjetivosFacade extends AbstractFacade<Objetivos> implements ObjetivosFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivosFacade() {
        super(Objetivos.class);
    }

    @Override
    public List<Objetivos> findObjGeneralByProyectoId(Proyecto proy) throws Exception {
         try {
            Query q = em.createNamedQuery("Objetivos.findObjGeneralByProyectoId");
            q.setParameter("proyecto", proy);
            q.setParameter("tipo", "OBJETIVO GENERAL");
           
            return (List<Objetivos>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Objetivos> findObjEspecificoslByProyectoId(Proyecto proy) throws Exception {
        try {
            Query q = em.createNamedQuery("Objetivos.findObjEspecificosByProyectoId");
            q.setParameter("proyecto", proy);
            q.setParameter("tipo", "OBJETIVO ESPECIFICO");
           
            return (List<Objetivos>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Objetivos> findAllById(Proyecto proy) {
          try {
            Query q = em.createNamedQuery("Objetivos.findAllById");
            q.setParameter("proyecto", proy);
            
           
            return (List<Objetivos>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
