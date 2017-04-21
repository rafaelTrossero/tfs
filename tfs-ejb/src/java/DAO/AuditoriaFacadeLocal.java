/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Auditoria;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface AuditoriaFacadeLocal {

    void create(Auditoria auditoria);

    void edit(Auditoria auditoria);

    void remove(Auditoria auditoria);

    Auditoria find(Object id);

    List<Auditoria> findAll();

    List<Auditoria> findRange(int[] range);
    
    List<Auditoria> findByDates(Date dia_inicial, Date dia_final);

    int count();
}
