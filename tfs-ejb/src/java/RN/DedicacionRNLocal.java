/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Dedicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface DedicacionRNLocal {
    
    void create(Dedicacion d) throws Exception;

    void remove(Dedicacion d) throws Exception;

    void edit(Dedicacion d) throws Exception;

    List<Dedicacion> findAll() throws Exception;
    
    
}
