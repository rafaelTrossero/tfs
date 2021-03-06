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
 * @author jorge
 */
@Local
public interface TribunalRNLocal {

    void create(Tribunal tribunal, Proyecto proyecto) throws Exception;

    void remove(Tribunal tribunal) throws Exception;

    void edit(Tribunal tribunal) throws Exception;

    List<Tribunal> findAll() throws Exception;

    public Tribunal findByTribunal(String resolucion, long pre, long voc1, long voc2, long sup1, long sup2) throws Exception;

    public ProyectoTribunal findByProy_Tribunal(Proyecto pro, boolean active) throws Exception;
    
    List<Tribunal> findTribunalByDocente(long idDoc) throws Exception;
    
    public Tribunal findTribunal(Proyecto pro, boolean active) throws Exception;

}
