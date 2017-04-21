/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Carrera;
import entidad.ProyectosInvestigacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author WalterVergara
 */
@Stateless
public class ProyectosInvestigacionFacade extends AbstractFacade<ProyectosInvestigacion> implements ProyectosInvestigacionFacadeLocal {
    
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ProyectosInvestigacionFacade() {
        super(ProyectosInvestigacion.class);
    }
  

    @Override
    public List<ProyectosInvestigacion> findAllActivo() {
         try {
            Query q = em.createNamedQuery("ProyectosInvestigacion.SelectAll");

            q.setParameter("active", true);

            return (List<ProyectosInvestigacion>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void activate(ProyectosInvestigacion c, Boolean bEstado) throws Exception {
        Query q = em.createNamedQuery("ProyectosInvestigacion.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", c.getId());
        
        q.executeUpdate();
    }
}
