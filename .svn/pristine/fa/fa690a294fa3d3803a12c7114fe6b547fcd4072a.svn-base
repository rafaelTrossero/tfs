/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.AutoridadesDepartamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class AutoridadesDepartamentoFacade extends AbstractFacade<AutoridadesDepartamento> implements AutoridadesDepartamentoFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoridadesDepartamentoFacade() {
        super(AutoridadesDepartamento.class);
    }

    @Override
    public AutoridadesDepartamento findAutoridades() throws Exception {
           try {
            Query q = em.createNamedQuery("AutoridadesDepartamento.findAutoridades");

            return (AutoridadesDepartamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
    
}
