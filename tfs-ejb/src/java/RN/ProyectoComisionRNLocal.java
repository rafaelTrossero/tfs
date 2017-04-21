/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.ProyectoComision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoComisionRNLocal {
    
     void create (ProyectoComision comision) throws Exception;
    
    void remove (ProyectoComision comision) throws Exception;
    
    void edit (ProyectoComision comision) throws Exception;
    
    List<ProyectoComision> findAll() throws Exception;
}
