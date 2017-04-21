/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.AuditoriaFacadeLocal;
import entidad.Auditoria;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class AuditoriaRN implements AuditoriaRNLocal {
  @EJB
  private AuditoriaFacadeLocal auditoriaFacadeLocal;
  
  @Override
  public List<Auditoria> findAll() throws Exception {
    return(auditoriaFacadeLocal.findAll());
  }

  @Override
  public List<Auditoria> findByDates(Date dia_inicial, Date dia_final) throws Exception {
    return(auditoriaFacadeLocal.findByDates(dia_inicial, dia_final));
  }
}
