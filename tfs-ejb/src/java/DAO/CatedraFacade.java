/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Carrera;
import entidad.Catedra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class CatedraFacade extends AbstractFacade<Catedra> implements CatedraFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatedraFacade() {
        super(Catedra.class);
    }

    @Override
    public void activate(Catedra c, Boolean bEstado) throws Exception {
        Query q = em.createNamedQuery("Catedra.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", c.getId());
        
        q.executeUpdate();
    }

    @Override
    public Boolean findByCarrearaName(Catedra cat, int op) throws Exception {
         Query q = null;
        
         if (op == 0) {
            //guardar
            q = em.createNamedQuery("Catedra.FindByCarreraName");

        } else {
            //modificar
            q = em.createNamedQuery("Catedra.findByNombreCarreraID");
            q.setParameter("id", cat.getId());


        }//fin if
          q.setParameter("nombre", cat.getNombre());
          
           try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
          
    }

    @Override
    public Catedra findByNombreCarreraID(Long id, String nombre) throws Exception {
        
        Query q = null;

        q = em.createNamedQuery("Catedra.findByNombreCarreraID");
        q.setParameter("id", id);
        q.setParameter("nombre", nombre);

        return ((Catedra) q.getSingleResult());
    }

    @Override
    public List<Catedra> findAllActivo() {
         try {
            Query q = em.createNamedQuery("Catedra.SelectAll");

            q.setParameter("active", true);

            return (List<Catedra>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Catedra> findAllCarrera(Long id) throws Exception {
      try {
            Query q = em.createNamedQuery("Ctedra.SelectCarrera");

            q.setParameter("idCarrera", id);

            return (List<Catedra>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    
    }

    @Override
    public List<Catedra> findCatedraCuro(String curso) throws Exception {
      try {
            Query q = em.createNamedQuery("Ctedra.SelectCatedraCurso");

            q.setParameter("idCurso", curso);

            return (List<Catedra>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    
    }

    @Override
    public List<Catedra> findAllcatedraLIKE(String a) throws Exception {
        try {
            Query q = em.createNamedQuery("Catedra.FindByCatedraLIKE");

            
            q.setParameter("x", '%' + a + '%');

            return (List<Catedra>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    
    }
    }
    

