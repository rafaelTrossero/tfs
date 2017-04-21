/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Comision;
import entidad.Docente;
import entidad.DocenteComision;
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
public class DocenteComisionFacade extends AbstractFacade<DocenteComision> implements DocenteComisionFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteComisionFacade() {
        super(DocenteComision.class);
    }

    @Override
    public DocenteComision findByDocente(DocenteComision doc) throws Exception {
    try {
            Query q = em.createNamedQuery("DocenteComision.findByDocente");

            q.setParameter("docID", doc.getDocente());
            
           
            return (DocenteComision) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }   
    }

    @Override
    public Comision findByIdDocente(long idDoc) throws Exception {
        
            try {
            Query q = em.createNamedQuery("DocenteComision.findByIdDocente");

            q.setParameter("idDoc", idDoc);
            
           
            return (Comision) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }   
        
    }

    @Override
    public List<Docente> findDocentesbyComision(long idComision) throws Exception {
        try {
            Query q = em.createNamedQuery("DocenteComision.findDocentesByComision");

            q.setParameter("idComision", idComision);
           
            return (List<Docente>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
