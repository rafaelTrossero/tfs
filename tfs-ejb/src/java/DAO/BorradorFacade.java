/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Borrador;
import entidad.Proyecto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Trossero
 */
@Stateless
public class BorradorFacade extends AbstractFacade<Borrador> implements BorradorFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorradorFacade() {
        super(Borrador.class);
    }

    @Override
    public Long findByProyecto(Proyecto proyecto) throws Exception {
       try { 
            Query q = em.createNamedQuery("Borrador.findByProyecto");
            q.setParameter("proyecto", proyecto);
            
            return (Long) q.getSingleResult();
            } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Borrador findById(Long id) throws Exception {
        try { 
            Query q = em.createNamedQuery("Borrador.findById");
            q.setParameter("id", id);
            
            return (Borrador) q.getSingleResult();
            } catch (Exception e) {
            return null;
        }
    }
    
}