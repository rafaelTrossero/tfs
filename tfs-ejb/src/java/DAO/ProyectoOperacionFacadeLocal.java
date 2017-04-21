/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoOperacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoOperacionFacadeLocal {

    void create(ProyectoOperacion proy_operacion);

    void edit(ProyectoOperacion proy_operacion);

    void remove(ProyectoOperacion proy_operacion);

    ProyectoOperacion find(Object id);

    List<ProyectoOperacion> findAll();

    List<ProyectoOperacion> findRange(int[] range);

    int count();
    
}
