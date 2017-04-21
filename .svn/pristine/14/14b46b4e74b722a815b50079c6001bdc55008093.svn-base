/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Calificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CalificacionRNLocal {
    
    void create(Calificacion c) throws Exception;

    void remove(Calificacion c) throws Exception;

    void edit(Calificacion c) throws Exception;

    List<Calificacion> findAll() throws Exception;
    
    public Calificacion findById(Long id)  throws Exception;
}
