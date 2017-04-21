/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.DefensaFinalObservaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Trossero
 */
@Stateless
public class DefensaFinalObservacionesFacade extends AbstractFacade<DefensaFinalObservaciones> implements DefensaFinalObservacionesFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefensaFinalObservacionesFacade() {
        super(DefensaFinalObservaciones.class);
    }
    
}
