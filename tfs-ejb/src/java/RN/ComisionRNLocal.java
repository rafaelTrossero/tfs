/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Carrera;
import entidad.Comision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface ComisionRNLocal {
    
     void create(Comision c) throws Exception;

    void remove(Comision c) throws Exception;

    void edit(Comision c) throws Exception;

    List<Comision> findAll() throws Exception;
    
    public void activate(Comision c, Boolean bEstado) throws Exception;
    
     List<Comision> findAllActivo() throws Exception;
}