/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.GuiaEvaluacion2_1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_1Facade extends AbstractFacade<GuiaEvaluacion2_1> implements GuiaEvaluacion2_1FacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaEvaluacion2_1Facade() {
        super(GuiaEvaluacion2_1.class);
    }
    
}
