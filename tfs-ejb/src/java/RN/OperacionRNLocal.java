/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Operacion;
import entidad.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface OperacionRNLocal {

    void create(Operacion p) throws Exception;

    void remove(Operacion p) throws Exception;

    void edit(Operacion p) throws Exception;

    List<Operacion> findAll() throws Exception;
}
