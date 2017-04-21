/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jmoreno
 */
@Local
public interface personaRNLocal {

    void create(Persona p) throws Exception;

    void remove(Persona p) throws Exception;

    void edit(Persona p) throws Exception;

    List<Persona> findAll() throws Exception;

}
