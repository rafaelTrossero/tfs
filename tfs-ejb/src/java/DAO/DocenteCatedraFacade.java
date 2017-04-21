/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Catedra;
import entidad.Comision;
import entidad.Docente;
import entidad.DocenteCatedra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class DocenteCatedraFacade extends AbstractFacade<DocenteCatedra> implements DocenteCatedraFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteCatedraFacade() {
        super(DocenteCatedra.class);
    }

    @Override
    public DocenteCatedra findByDocente(DocenteCatedra doc) throws Exception {
         try {
            Query q = em.createNamedQuery("DocenteCatedra.findByDocente");

            q.setParameter("docID", doc.getDocente());
            
           
            return (DocenteCatedra) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }   
    }

    @Override
    public List<Docente> findDocentesbyCatedra (long idCatedra) throws Exception {
            try {
            Query q = em.createNamedQuery("DocenteCatedra.findDocentesByComision");

            q.setParameter("idCatedra", idCatedra);
           
            return (List<Docente>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public Catedra findByIdDocente(long idDoc) throws Exception {
        
            try {
            Query q = em.createNamedQuery("DocenteCatedra.findByIdDocente");

            q.setParameter("idDoc", idDoc);
            
           
            return (Catedra) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }   
    }

    @Override
    public List<DocenteCatedra> findCatedraDocente(Catedra catedra) throws Exception {

        try {
            Query q = em.createNamedQuery("DocenteCatedra.BuscarCatedraDocente");

            q.setParameter("catedra", catedra);
           
            return (List<DocenteCatedra>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
