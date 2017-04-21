/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Auditoria;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class AuditoriaFacade extends AbstractFacade<Auditoria> implements AuditoriaFacadeLocal {

  @PersistenceContext(unitName = "tfs-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public AuditoriaFacade() {
    super(Auditoria.class);
  }

  @Override
  public List<Auditoria> findByDates(Date dia_inicial, Date dia_final) {
    Query q = null;

    q = em.createNamedQuery("Auditoria.FindByDates");
    q.setParameter("fecha_inicial", dia_inicial);
    q.setParameter("fecha_final", dia_final);

    return (q.getResultList());
  }
}
