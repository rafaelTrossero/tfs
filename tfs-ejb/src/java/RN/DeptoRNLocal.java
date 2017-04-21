/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Depto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface DeptoRNLocal {

    void create(Depto p) throws Exception;

    void remove(Depto p) throws Exception;

    void edit(Depto p) throws Exception;

    List<Depto> findAll() throws Exception;
    
     public void activate(Depto c, Boolean bEstado) throws Exception;
      List<Depto> findAllActivo() throws Exception;
}
