/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoComision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoComisionFacadeLocal {

    void create(ProyectoComision proy_comision);

    void edit(ProyectoComision proy_comision);

    void remove(ProyectoComision proy_comision);

    ProyectoComision find(Object id);

    List<ProyectoComision> findAll();

    List<ProyectoComision> findRange(int[] range);

    int count();
    
}
