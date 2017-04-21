/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoEvaluacionObservaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoEvaluacionObservacionesFacade extends AbstractFacade<ProyectoEvaluacionObservaciones> implements ProyectoEvaluacionObservacionesFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoEvaluacionObservacionesFacade() {
        super(ProyectoEvaluacionObservaciones.class);
    }
    
}
