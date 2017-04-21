/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Noticias;
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
public class NoticiasFacade extends AbstractFacade<Noticias> implements NoticiasFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticiasFacade() {
        super(Noticias.class);
    }

    @Override
    public List<Noticias> findUltimaNoticia() {
          try {
            Query q = em.createNamedQuery("Noticias.findUltimaNoticia");

            return (List<Noticias>) q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }
    
}
