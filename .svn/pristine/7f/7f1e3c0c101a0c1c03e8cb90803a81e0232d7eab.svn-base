/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Docente;
import entidad.Profesional;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface ProyectoCodirectorRNLocal {
    void create (ProyectoCodirector a) throws Exception;
    
    void remove (ProyectoCodirector  a) throws Exception;
    
    void edit (ProyectoCodirector  a) throws Exception;
    
    List<ProyectoCodirector > findAll() throws Exception;
        
    public void  validar( Docente proDirec,List<Profesional> proyAsesor , List<Profesional> proyCodirector)  throws Exception;
    
    List<ProyectoCodirector> findByProyCodirector (Proyecto pro, boolean active) throws Exception;
     public List<ProyectoCodirector> findByProyectoCodirector(long doc) throws Exception;
      public List<ProyectoCodirector> findProyByDocenteCodirector(long docente)  throws Exception;
}
