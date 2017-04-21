/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Estado;
import entidad.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface EstadoRNLocal {
     void create(Estado p) throws Exception;

    void remove(Estado p) throws Exception;

    void edit(Estado p) throws Exception;

    List<Estado> findAll() throws Exception;
}
