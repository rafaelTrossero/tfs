/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Cronograma;
import entidad.CronogramaActividad;
//import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Trossero
 */
@Stateless
public class CronogramaActividadFacade extends AbstractFacade<CronogramaActividad> implements CronogramaActividadFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CronogramaActividadFacade() {
        super(CronogramaActividad.class);
    }

    @Override
    public List<CronogramaActividad> findByCronogramaActividad(Cronograma cro) throws Exception {
    try {
            Query q = em.createNamedQuery("CronogramaActividad.findByCronogramaActividad");

            q.setParameter("croID", cro);

            return (List<CronogramaActividad>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    
    }

    @Override
    public CronogramaActividad findByCronograma(long longid) throws Exception {
  try {
            Query q = em.createNamedQuery("CronogramaActividad.findByCronograma");

            q.setParameter("longID", longid);

            return (CronogramaActividad) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    
    
    }

    @Override
    public List<CronogramaActividad> findByFueraDeFecha() throws Exception {
       try {
            Query q = em.createNamedQuery("CronogramaActividad.findByFueraDeFecha");

            q.setParameter("fechaActual", Date.class.newInstance());

            return (List<CronogramaActividad>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
