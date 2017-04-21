/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Docente;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoDirectorFacade extends AbstractFacade<ProyectoDirector> implements ProyectoDirectorFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoDirectorFacade() {
        super(ProyectoDirector.class);
    }

    @Override
    public List<ProyectoDirector> findByProyDirector(Proyecto pro) throws Exception {
        try {

            Query q = em.createNamedQuery("ProyectoDirector.findByProyDirector");

            q.setParameter("proID", pro);
            q.setParameter("estado", true);

            return (List<ProyectoDirector>) q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ProyectoDirector findProyDirectorActivo(Proyecto pro, boolean active) throws Exception {
        try {
            Query q = em.createNamedQuery("ProyectoDirector.findDirectorActivo");

            q.setParameter("proID", pro);
            q.setParameter("estado", active);

            return (ProyectoDirector) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProyectoDirector> findByProyectoDirector(long idDoc) throws Exception {
             try {
            Query q = em.createNamedQuery("proyDirector.findByproyectos");

            q.setParameter("docID", idDoc);
            
           
            return (List<ProyectoDirector>) q.getResultList();
        } catch (Exception e) {
            return null;
}
    
    }

    @Override
    public List<ProyectoDirector> findProydirector(Docente docente) {
      try {
            Query q = em.createNamedQuery("Proyecto.FindDocenteDirector");

            q.setParameter("docente", docente);
           
            return (List<ProyectoDirector>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    }

   
}
