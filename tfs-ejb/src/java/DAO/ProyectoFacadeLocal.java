/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Carrera;
import entidad.Estado;
import entidad.Proyecto;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoFacadeLocal {

    void create(Proyecto proyecto);

    void edit(Proyecto proyecto);

    void remove(Proyecto proyecto);

    Proyecto find(Object id);

    List<Proyecto> findAll();

    List<Proyecto> findRange(int[] range);

    int count();
    public void activate(Proyecto p, Boolean bEstado) throws Exception;
     public Estado findByEstado(Integer estado) throws Exception;
     
     public Proyecto findProyectoName(Proyecto proy) throws Exception;

    public List<Proyecto> findProyByEstado(Integer estado);
     public List<Proyecto> findProyByCarrera(Carrera carrera);
    
     public List<Proyecto> findProyectosAtrasados(Integer estado, Integer dias);
    
    
    
}