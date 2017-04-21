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
 * @author jorge
 */
@Local
public interface TribunalFacadeLocal {

    void create(Tribunal tribunal);

    void edit(Tribunal tribunal);

    void remove(Tribunal tribunal);

    Tribunal find(Object id);

    List<Tribunal> findAll();

    List<Tribunal> findRange(int[] range);

    int count();

    public Tribunal findByTribunal(String resolucion, long pre, long voc1, long voc2, long sup1, long sup2) throws Exception;

    public ProyectoTribunal findByProyTribunal(Proyecto pro, boolean active) throws Exception;
    
    List<Tribunal> findTribunalByDocente(long idDoc) throws Exception;
    
    public Tribunal findTribunal(Proyecto pro, boolean active) throws Exception;

}
