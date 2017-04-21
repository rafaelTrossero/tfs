/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Catedra;
import entidad.Horario_catedra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cris
 */
@Stateless
public class Horario_catedraFacade extends AbstractFacade<Horario_catedra> implements Horario_catedraFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Horario_catedraFacade() {
        super(Horario_catedra.class);
    }

    @Override
    public Horario_catedra buscar_horario(Catedra catedra) {
   try {
            Query q = em.createNamedQuery("Horario_catedra.BuscarCatedra");

            q.setParameter("catedra", catedra);

            return (Horario_catedra) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    
    
    }
   
}
