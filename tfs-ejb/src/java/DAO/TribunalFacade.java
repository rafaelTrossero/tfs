/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.ProyectoTribunal;
import entidad.Proyecto;
import entidad.Tribunal;
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
public class TribunalFacade extends AbstractFacade<Tribunal> implements TribunalFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TribunalFacade() {
        super(Tribunal.class);
    }

    @Override
    public Tribunal findByTribunal(String resolucion, long pre, long voc1, long voc2, long sup1, long sup2) throws Exception {
        try {
            Query q = em.createNamedQuery("tribunal.findByTribunal");
            q.setParameter("resolucion", resolucion);
            q.setParameter("preID", pre);
            q.setParameter("voc1ID", voc1);
            q.setParameter("voc2ID", voc2);
            q.setParameter("sup1ID", sup1);
            q.setParameter("sup2ID", sup2);

            return (Tribunal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProyectoTribunal findByProyTribunal(Proyecto pro, boolean active) throws Exception {
        try {
            Query q = em.createNamedQuery("Proy_Tribunal.findByProyTribunal");
            q.setParameter("proyecto", pro);
            q.setParameter("active", active);

            return (ProyectoTribunal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Tribunal> findTribunalByDocente(long idDoc) throws Exception {
       try {
            Query q = em.createNamedQuery("Proy_Tribunal.findTribunalByDocente");
            q.setParameter("idDoc", idDoc);
          

            return (List<Tribunal>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Tribunal findTribunal(Proyecto pro, boolean active) throws Exception {
        try {
            Query q = em.createNamedQuery("Proy_tribunal.findTribunal");
            q.setParameter("proyecto", pro);
            q.setParameter("active", active);

            return (Tribunal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
