/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Aceptacion;
import entidad.Calificacion;
import entidad.DefensaFinal;
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
public interface DefensaFinalFacadeLocal {

    void create(DefensaFinal defensa_Final);

    void edit(DefensaFinal defensa_Final);

    void remove(DefensaFinal defensa_Final);

    DefensaFinal find(Object id);

    List<DefensaFinal> findAll();

    List<DefensaFinal> findRange(int[] range);

    int count();
    
    public DefensaFinal findbyDefensa(Proyecto proy, Tribunal trib) throws Exception;
    
    public List<DefensaFinal> findProyAprobados(Date fecha1, Date fecha2)throws Exception;;
    
}
