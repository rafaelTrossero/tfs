/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Auditoria;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Pablo
 */
@Local
public interface AuditoriaRNLocal {
    public List<Auditoria> findAll() throws Exception;
    public List<Auditoria> findByDates(Date dia_inicial, Date dia_final) throws Exception;
}
