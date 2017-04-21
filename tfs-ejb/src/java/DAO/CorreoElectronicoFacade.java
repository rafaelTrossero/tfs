/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.CorreoElectronico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Trossero
 */
@Stateless
public class CorreoElectronicoFacade extends AbstractFacade<CorreoElectronico> implements CorreoElectronicoFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreoElectronicoFacade() {
        super(CorreoElectronico.class);
    }
    
}
