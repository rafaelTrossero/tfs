/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.EvaluacionProyecto;
import entidad.Presentacion;
import entidad.ProyectoTribunal;
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
public class EvaluacionProyectoFacade extends AbstractFacade<EvaluacionProyecto> implements EvaluacionProyectoFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionProyectoFacade() {
        super(EvaluacionProyecto.class);
    }

    @Override
    public EvaluacionProyecto findByEvaluacion(Proyecto pro, Presentacion pres) throws Exception {
        try {
            Query q = em.createNamedQuery("evaluacion.findByEvaluacion");
            q.setParameter("proyecto", pro);
            q.setParameter("presentacion", pres);

            return (EvaluacionProyecto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
     @Override
    public List<EvaluacionProyecto> findByEvaluacionByProyecto(Proyecto pro) throws Exception {
        try {
            Query q = em.createNamedQuery("evaluacion.findByEvaluacionByProyecto");
            q.setParameter("proyecto", pro);
            

            return (List<EvaluacionProyecto>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public EvaluacionProyecto findByProyectoYcalif(Proyecto pro, Integer cal) throws Exception {
       try {
            Query q = em.createNamedQuery("evaluacion.findByProyectoYcalif");
            q.setParameter("proyecto", pro);
       
            q.setParameter("calificacion", cal);
           
            return (EvaluacionProyecto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    
}
