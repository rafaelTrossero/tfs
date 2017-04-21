/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
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
public class ProyectoCodirectorFacade extends AbstractFacade<ProyectoCodirector> implements ProyectoCodirectorFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoCodirectorFacade() {
        super(ProyectoCodirector.class);
    }

    @Override
    public List<ProyectoCodirector> findCodirectorActivo(Proyecto pro, boolean active) throws Exception {

        try {
            Query q = em.createNamedQuery("ProyectoCodirector.findCodirectorActivo");

            q.setParameter("proID", pro);
            q.setParameter("estado", active);

            return (List<ProyectoCodirector>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProyectoCodirector> findByProyCodirector(Proyecto pro, boolean active) throws Exception {

        try {

            Query q = em.createNamedQuery("ProyectoCodirector.findByProyCodirector");

            q.setParameter("proID", pro);
            q.setParameter("estado", active);

            return (List<ProyectoCodirector>) q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<ProyectoCodirector> findByProyectoCodirector(long idDoc) throws Exception {
        try {
            Query q = em.createNamedQuery("proyCodirector.findByproyectosCod");

            q.setParameter("docID", idDoc);

            return (List<ProyectoCodirector>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProyectoCodirector> findProyCodirector(long docente) {
         try {
            Query q = em.createNamedQuery("Proyecto.FindDocenteCoDirector");

            q.setParameter("docente", docente);
           
            return (List<ProyectoCodirector>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    }
}
