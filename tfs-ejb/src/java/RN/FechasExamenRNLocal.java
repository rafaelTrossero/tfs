/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.FechasExamen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface FechasExamenRNLocal {
    
     void create(FechasExamen p) throws Exception;

    void remove(FechasExamen p) throws Exception;

    void edit(FechasExamen p) throws Exception;

    List<FechasExamen> findAll() throws Exception;
}
