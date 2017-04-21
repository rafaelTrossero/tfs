/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.ProyectoAsesor;
import entidad.ProyectoDirector;
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
public class ProyectoAsesorFacade extends AbstractFacade<ProyectoAsesor> implements ProyectoAsesorFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoAsesorFacade() {
        super(ProyectoAsesor.class);
    }

    @Override
    public List<ProyectoAsesor> findByProyAsesor(Proyecto pro, boolean active) throws Exception {



        try {

            Query q = em.createNamedQuery("ProyectoAsesor.findByProyAsesor");

            q.setParameter("proID", pro);
            q.setParameter("estado", active);

            return (List<ProyectoAsesor>) q.getResultList();
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public List<ProyectoAsesor> findByProyectoAsesor(long idDoc) throws Exception {
         try {
            Query q = em.createNamedQuery("proyAsesor.findByproyectos");

            q.setParameter("docID", idDoc);
            
           
            return (List<ProyectoAsesor>) q.getResultList();
        } catch (Exception e) {
            return null;
        }  
    
    }

    @Override
    public List<ProyectoAsesor> findProyAsesor(long docente) {
    try {
            Query q = em.createNamedQuery("Proyecto.FindDocenteAsesor");

            q.setParameter("docente", docente);
           
            return (List<ProyectoAsesor>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    }
}
