/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Aceptacion;
import entidad.Calificacion;
import entidad.DefensaFinal;
import entidad.Docente;
import entidad.Presentacion;
import entidad.Proyecto;
import entidad.Tribunal;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface DefensaFinalRNLocal {
    void create(DefensaFinal p) throws Exception;

    void remove(DefensaFinal p) throws Exception;

    void edit(DefensaFinal p) throws Exception;

    List<DefensaFinal> findAll() throws Exception;
    
    public DefensaFinal findByDefensa (Proyecto pro, Tribunal trib)  throws Exception;
    
    public List<DefensaFinal> findProyAprobados( Date fecha1, Date fecha2)  throws Exception;
}
