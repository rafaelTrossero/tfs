/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoAlumno;
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
public class ProyectoAlumnoFacade extends AbstractFacade<ProyectoAlumno> implements ProyectoAlumnoFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoAlumnoFacade() {
        super(ProyectoAlumno.class);
    }

    @Override
    public List<ProyectoAlumno> findByProyAlumno(Proyecto pro) throws Exception {
try {
            Query q = em.createNamedQuery("ProyectoAlumno.findByProyAlumno");

            q.setParameter("proID", pro);

            return (List<ProyectoAlumno>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    }
    
    @Override
    public ProyectoAlumno findByProyectoAlumno(long alu) throws Exception {
      try {
            Query q = em.createNamedQuery("proyAlumno.findByproyectos");

            q.setParameter("aluID", alu);
            
           
            return (ProyectoAlumno) q.getSingleResult();
        } catch (Exception e) {
            return null;
}
    }
    
}
