/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Cargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface CargoRNLocal {
    
    void create(Cargo c) throws Exception;

    void remove(Cargo c) throws Exception;

    void edit(Cargo c) throws Exception;

    List<Cargo> findAll() throws Exception;
}
