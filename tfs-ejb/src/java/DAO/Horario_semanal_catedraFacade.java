/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import static entidad.Carrera_.catedra;
import entidad.Horario_catedra;
import entidad.Horario_semanal_catedra;
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
public class Horario_semanal_catedraFacade extends AbstractFacade<Horario_semanal_catedra> implements Horario_semanal_catedraFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Horario_semanal_catedraFacade() {
        super(Horario_semanal_catedra.class);
    }

    @Override
    public List<Horario_semanal_catedra> findHorarios(Horario_catedra hora_cated) {
     try {
            Query q = em.createNamedQuery("Horario_semanal_catedra.BuscarHorarios");

            q.setParameter("hora_catedra", hora_cated);

            return (List<Horario_semanal_catedra>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    
    }
    
}
