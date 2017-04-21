/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.NotaFinalAlumno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class NotaFinalAlumnoFacade extends AbstractFacade<NotaFinalAlumno> implements NotaFinalAlumnoFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaFinalAlumnoFacade() {
        super(NotaFinalAlumno.class);
    }
    
}
