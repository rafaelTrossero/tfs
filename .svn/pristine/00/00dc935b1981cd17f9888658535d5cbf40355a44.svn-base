/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoEvaluacionObservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoEvaluacionObservacionesFacadeLocal {

    void create(ProyectoEvaluacionObservaciones proy_evaluacion_obs);

    void edit(ProyectoEvaluacionObservaciones proy_evaluacion_obs);

    void remove(ProyectoEvaluacionObservaciones proy_evaluacion_obs);

    ProyectoEvaluacionObservaciones find(Object id);

    List<ProyectoEvaluacionObservaciones> findAll();

    List<ProyectoEvaluacionObservaciones> findRange(int[] range);

    int count();
    
}
