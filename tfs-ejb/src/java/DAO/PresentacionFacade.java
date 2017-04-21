/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Presentacion;
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
public class PresentacionFacade extends AbstractFacade<Presentacion> implements PresentacionFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresentacionFacade() {
        super(Presentacion.class);
    }

    @Override
    public List<Presentacion> findPresentacion(Proyecto pro, String cert, String nota, String notadir) {
        try {
            Query q = em.createNamedQuery("Presentacion.findPresentacion");

           // q.setParameter("certificado", cert);
            //q.setParameter("nota", nota);
            // q.setParameter("notadir", notadir);
            q.setParameter("proyecto", pro.getId());
            q.setParameter("certificado", cert);

            return (List<Presentacion>) q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Long findPresCodigo(Proyecto proy, boolean requisito) throws Exception {
        try {
            Query q = em.createNamedQuery("Presentacion.findPresentacionCodigo");

           // q.setParameter("certificado", cert);
            //q.setParameter("nota", nota);
            // q.setParameter("notadir", notadir);
            q.setParameter("proyecto", proy);
            q.setParameter("requisito", requisito);

            return (Long) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Presentacion findByPresentacion(long codigo) throws Exception {
        try {
            Query q = em.createNamedQuery("Presentacion.findPresentacion");

           // q.setParameter("certificado", cert);
            //q.setParameter("nota", nota);
            // q.setParameter("notadir", notadir);
            q.setParameter("codigoPresentacion", codigo);

            return (Presentacion) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

}
