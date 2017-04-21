/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Dedicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface DedicacionFacadeLocal {

    void create(Dedicacion dedicaciones);

    void edit(Dedicacion dedicaciones);

    void remove(Dedicacion dedicaciones);

    Dedicacion find(Object id);

    List<Dedicacion> findAll();

    List<Dedicacion> findRange(int[] range);

    int count();
    
}
