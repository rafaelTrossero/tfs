/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.EvaluacionAspectos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface EvaluacionAspectosRNLocal {
    
     void create(EvaluacionAspectos p) throws Exception;

    void remove(EvaluacionAspectos p) throws Exception;

    void edit(EvaluacionAspectos p) throws Exception;

    List<EvaluacionAspectos> findAll() throws Exception;
}
