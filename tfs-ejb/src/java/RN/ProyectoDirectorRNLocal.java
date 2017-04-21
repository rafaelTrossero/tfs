/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Carrera;
import entidad.Docente;
import entidad.Proyecto;
import entidad.ProyectoComision;
import entidad.ProyectoDirector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoDirectorRNLocal {
    
        void create (ProyectoDirector director) throws Exception;
    
    void remove (ProyectoDirector director) throws Exception;
    
    void edit (ProyectoDirector director) throws Exception;
    
    List<ProyectoDirector> findAll() throws Exception;
    public List<ProyectoDirector> findByProyDirector (Proyecto pro)  throws Exception;
    public ProyectoDirector findProyDirectorActivo (Proyecto pro,boolean activo)  throws Exception;
    public List<ProyectoDirector> findByProyectoDirector(long doc) throws Exception;
    public List<ProyectoDirector> findProyByDocente(Docente docente)  throws Exception;
}
