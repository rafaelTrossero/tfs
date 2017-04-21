/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Cronograma;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CronogramaRNLocal {
    
    void create(Cronograma c) throws Exception;

    void remove(Cronograma c) throws Exception;

    void edit(Cronograma c) throws Exception;

    List<Cronograma> findAll() throws Exception;
    public Cronograma findByCronograma (Proyecto proy) throws Exception;
}
