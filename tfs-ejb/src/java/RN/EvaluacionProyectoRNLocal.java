/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.EvaluacionProyecto;
import entidad.Persona;
import entidad.Presentacion;
import entidad.ProyectoTribunal;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface EvaluacionProyectoRNLocal {
     void create(EvaluacionProyecto p) throws Exception;

    void remove(EvaluacionProyecto p) throws Exception;

    void edit(EvaluacionProyecto p) throws Exception;

    List<EvaluacionProyecto> findAll() throws Exception;
    
     public EvaluacionProyecto findByEvaluacionl(Proyecto pro, Presentacion pres) throws Exception;
     
     public List<EvaluacionProyecto> findByEvaluacion(Proyecto pro) throws Exception;
     
      public List<EvaluacionProyecto> findByEvaluacionByProyecto (Proyecto pro) throws Exception;
      
     public EvaluacionProyecto findByProyectoYcalif (Proyecto pro, Integer cal)  throws Exception; 
     
}
