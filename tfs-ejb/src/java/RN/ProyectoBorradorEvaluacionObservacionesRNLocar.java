/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.ProyectoAlumno;
import entidad.ProyectoBorradorEvaluacionObservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoBorradorEvaluacionObservacionesRNLocar {
    
    void create (ProyectoBorradorEvaluacionObservaciones borradorEvaluacionObs) throws Exception;
    
    void remove (ProyectoBorradorEvaluacionObservaciones borradorEvaluacionObs) throws Exception;
    
    void edit (ProyectoBorradorEvaluacionObservaciones borradorEvaluacionObs) throws Exception;
    
    List<ProyectoBorradorEvaluacionObservaciones> findAll() throws Exception;
}
