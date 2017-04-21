/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.GuiaEvaluacion2_3_indicadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_3_indicadoresFacade extends AbstractFacade<GuiaEvaluacion2_3_indicadores> implements GuiaEvaluacion2_3_indicadoresFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaEvaluacion2_3_indicadoresFacade() {
        super(GuiaEvaluacion2_3_indicadores.class);
    }
    
}
