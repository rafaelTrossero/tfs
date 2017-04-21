/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Aceptacion;
import entidad.Calificacion;
import entidad.DefensaFinal;
import entidad.Presentacion;
import entidad.Proyecto;
import entidad.Tribunal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

/**
 *
 * @author cristian
 */
@Stateless
public class DefensaFinalFacade extends AbstractFacade<DefensaFinal> implements DefensaFinalFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefensaFinalFacade() {
        super(DefensaFinal.class);
    }
    
      @Override
    public DefensaFinal findbyDefensa(Proyecto proy, Tribunal trib) throws Exception {
        try {
            Query q = em.createNamedQuery("Defensa_Final.findByDefensa");
            q.setParameter("proy", proy);
            q.setParameter("trib", trib);
           
           
            return (DefensaFinal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<DefensaFinal> findProyAprobados(Date fecha1, Date fecha2) {
        try {
            Query q = em.createNamedQuery("DefensaFinal.findProyAprobados");

            
            q.setParameter("fecha1", fecha1);
            q.setParameter("fecha2", fecha2);
           
            return (List<DefensaFinal>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
