/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Alumno;
import entidad.Carrera;
import entidad.Estado;
import entidad.Proyecto;

import java.util.Date;

import entidad.ProyectoOperacion;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoRNbeanLocal {
    
    void create (Proyecto proyecto) throws Exception;
    
    void remove (Proyecto proyecto) throws Exception;
    
    void edit (Proyecto proyecto) throws Exception;
    
    List<Proyecto> findAll() throws Exception;
    
    public void activate(Proyecto p, Boolean bEstado) throws Exception;
    
    public Estado findByEstado(Integer estado)  throws Exception;
    public Proyecto findProyectoName(Proyecto proy)  throws Exception;
    public List<Proyecto> findProyByEstado(Integer estado)  throws Exception;

    
    


    
    public List<Proyecto> findProyectosAtrasados(Integer estado, Integer dias)  throws Exception;

    public List<Proyecto> findProyByCarrera(Carrera carrera)  throws Exception;


}