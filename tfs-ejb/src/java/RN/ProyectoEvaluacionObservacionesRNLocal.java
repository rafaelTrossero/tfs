/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.ProyectoDirector;
import entidad.ProyectoEvaluacionObservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoEvaluacionObservacionesRNLocal {
    void create (ProyectoEvaluacionObservaciones evaluacion) throws Exception;
    
    void remove (ProyectoEvaluacionObservaciones evaluacion) throws Exception;
    
    void edit (ProyectoEvaluacionObservaciones evaluacion) throws Exception;
    
    List<ProyectoEvaluacionObservaciones> findAll() throws Exception;
}
