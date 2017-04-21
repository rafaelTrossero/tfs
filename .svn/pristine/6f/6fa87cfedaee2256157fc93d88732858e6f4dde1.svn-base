/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.ProyectoTags;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface ProyectoTagsFacadeLocal {

    void create(ProyectoTags proyectoTags);

    void edit(ProyectoTags proyectoTags);

    void remove(ProyectoTags proyectoTags);

    ProyectoTags find(Object id);

    List<ProyectoTags> findAll();

    List<ProyectoTags> findRange(int[] range);

    int count();
    
}
