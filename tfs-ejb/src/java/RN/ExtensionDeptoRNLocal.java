/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.ExtensionDepto;
import entidad.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface ExtensionDeptoRNLocal {
     void create(ExtensionDepto p) throws Exception;

    void remove(ExtensionDepto p) throws Exception;

    void edit(ExtensionDepto p) throws Exception;

    List<ExtensionDepto> findAll() throws Exception;
}
