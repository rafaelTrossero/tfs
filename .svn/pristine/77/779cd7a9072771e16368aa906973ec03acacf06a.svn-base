/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Cronograma;
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
public class CronogramaFacade extends AbstractFacade<Cronograma> implements CronogramaFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CronogramaFacade() {
        super(Cronograma.class);
    }

    @Override
    public Cronograma findByCronograma(Proyecto pro) throws Exception {
       try {
            Query q = em.createNamedQuery("Cronograma.findByCronograma");

            q.setParameter("proID", pro);

            return (Cronograma) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    
    }
    
}
