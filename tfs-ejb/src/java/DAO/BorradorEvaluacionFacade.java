/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.BorradorEvaluacion;
import entidad.EvaluacionProyecto;
import entidad.Proyecto;
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
public class BorradorEvaluacionFacade extends AbstractFacade<BorradorEvaluacion> implements BorradorEvaluacionFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorradorEvaluacionFacade() {
        super(BorradorEvaluacion.class);
    }
    
       @Override
    public List<BorradorEvaluacion> findByEvaluacionBorrador(Proyecto pro) throws Exception {
        try {
            Query q = em.createNamedQuery("evaluacionBorrador.findByEvaluacionBorrador");
            q.setParameter("proyecto", pro);
            

            return (List<BorradorEvaluacion>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BorradorEvaluacion findByProyectoYcalif(Proyecto pro, Integer cal, Long borrador) throws Exception {
       try {
            Query q = em.createNamedQuery("evaluacionBorrador.findByProyectoYcalif");
            q.setParameter("proyecto", pro);
       
            q.setParameter("calificacion", cal);
            q.setParameter("borrador", borrador);
           
            return (BorradorEvaluacion) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
