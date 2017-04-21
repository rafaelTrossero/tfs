/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.GuiaEvaluacion2_2_indicadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_2_indicadoresFacade extends AbstractFacade<GuiaEvaluacion2_2_indicadores> implements GuiaEvaluacion2_2_indicadoresFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaEvaluacion2_2_indicadoresFacade() {
        super(GuiaEvaluacion2_2_indicadores.class);
    }
    
}
