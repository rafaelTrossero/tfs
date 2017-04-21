/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Carrera;
import entidad.Depto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorge
 */
@Stateless
public class CarreraFacade extends AbstractFacade<Carrera> implements CarreraFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarreraFacade() {
        super(Carrera.class);
    }

    @Override
    public void activate(Carrera c, Boolean bEstado) throws Exception {
        Query q = em.createNamedQuery("Carrera.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", c.getId());
        
        q.executeUpdate();
    }

    @Override
    public Boolean findByCarrearaName(Carrera car, int op) throws Exception {
       
        Query q = null;
        
         if (op == 0) {
            //guardar
            q = em.createNamedQuery("Carrera.FindByCarreraName");

        } else {
            //modificar
            q = em.createNamedQuery("Carrera.findByNombreCarreraID");
            q.setParameter("id", car.getId());


        }//fin if
          q.setParameter("nombre", car.getCarrera());
          
           try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
          
      
    
    }

    @Override
    public Carrera findByNombreCarreraID(Long id, String nombre) throws Exception {
        
   
        Query q = null;

        q = em.createNamedQuery("Carrera.findByNombreCarreraID");
        q.setParameter("id", id);
        q.setParameter("nombre", nombre);

        return ((Carrera) q.getSingleResult());
    }
      @Override
    public List<Carrera> findAllActivo() {
          try {
            Query q = em.createNamedQuery("Carrera.SelectAll");

            q.setParameter("active", true);

            return (List<Carrera>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Carrera> findAllDepartamento(Long id) throws Exception {
     
         try {
            Query q = em.createNamedQuery("Carrera.SelectDepartamento");

            q.setParameter("idDepartamento", id);

            return (List<Carrera>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    
    }
    
    }
    
