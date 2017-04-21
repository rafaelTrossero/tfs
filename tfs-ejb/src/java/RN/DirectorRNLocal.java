/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Director;
import entidad.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface DirectorRNLocal {
     void create(Director p) throws Exception;

    void remove(Director p) throws Exception;

    void edit(Director p) throws Exception;

    List<Director> findAll() throws Exception;
}
