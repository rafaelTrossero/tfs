/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.ProyectoOperacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoOperacionRNLocal {
    
    void create (ProyectoOperacion operacion) throws Exception;
    
    void remove (ProyectoOperacion operacion) throws Exception;
    
    void edit (ProyectoOperacion operacion) throws Exception;
    
    List<ProyectoOperacion> findAll() throws Exception;
}
