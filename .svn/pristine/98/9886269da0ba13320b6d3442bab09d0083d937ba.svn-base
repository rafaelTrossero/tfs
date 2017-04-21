/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Cronograma;
import entidad.CronogramaActividad;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CronogramaActividadRNLocal {
    
     void create(CronogramaActividad c) throws Exception;

    void remove(CronogramaActividad c) throws Exception;

    void edit(CronogramaActividad c) throws Exception;

    List<CronogramaActividad> findAll() throws Exception;
    public List<CronogramaActividad> findByCronogramaActividad (Cronograma cro) throws Exception;
    public CronogramaActividad findByCronograma (long longid) throws Exception;
    
    public List<CronogramaActividad> findByFueraDeFecha () throws Exception;
    
    
}
