/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.FechasExamen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface FechasExamenFacadeLocal {

    void create(FechasExamen fechasExamen);

    void edit(FechasExamen fechasExamen);

    void remove(FechasExamen fechasExamen);

    FechasExamen find(Object id);

    List<FechasExamen> findAll();

    List<FechasExamen> findRange(int[] range);

    int count();
    
}
