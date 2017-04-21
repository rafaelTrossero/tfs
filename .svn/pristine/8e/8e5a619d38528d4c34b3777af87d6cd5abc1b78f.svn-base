/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.ProyectoTribunal;
import entidad.Proyecto;
import entidad.Tribunal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface ProyectoTribunalRNLocal {
    
       void create (ProyectoTribunal proy_tribunal) throws Exception;
    
    void remove (ProyectoTribunal proy_tribunal) throws Exception;
    
    void edit ( ProyectoTribunal proy_tribunal) throws Exception;
    
    List<ProyectoTribunal> findAll() throws Exception;
    
    public Tribunal findTribunal(Proyecto proyecto, Boolean active);
    
    public Proyecto findProyectoByTribunal(long tribunal) throws Exception;
}
