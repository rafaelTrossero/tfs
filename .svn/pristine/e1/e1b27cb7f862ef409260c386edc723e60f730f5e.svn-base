/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Borrador;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface BorradorRNLocal {
    
     
    void create(Borrador b) throws Exception;

    void remove(Borrador b) throws Exception;

    void edit(Borrador b) throws Exception;

    List<Borrador> findAll() throws Exception;
    
   public Long findByProyecto (Proyecto proyecto) throws Exception;
   public Borrador findById (Long id) throws Exception;
}
