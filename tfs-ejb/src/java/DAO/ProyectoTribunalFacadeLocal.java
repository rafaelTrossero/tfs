/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

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
public interface ProyectoTribunalFacadeLocal {

    void create(ProyectoTribunal proy_tribunal);

    void edit(ProyectoTribunal proy_tribunal);

    void remove(ProyectoTribunal proy_tribunal);

    ProyectoTribunal find(Object id);

    List<ProyectoTribunal> findAll();

    List<ProyectoTribunal> findRange(int[] range);

    int count();
    
     public Tribunal findTribunal(Proyecto proyecto, Boolean active);
     
    public Proyecto findProyectoByTribunal(long tribunal) throws Exception;
}
