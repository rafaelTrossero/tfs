/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.AlumnoCarrera;
import entidad.Carrera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface CarreraFacadeLocal {

    void create(Carrera carrera);

    void edit(Carrera carrera);

    void remove(Carrera carrera);

    Carrera find(Object id);

    List<Carrera> findAll();

    List<Carrera> findRange(int[] range);

    int count();
    
    public void activate(Carrera c, Boolean bEstado) throws Exception;
     public Boolean findByCarrearaName(Carrera car, int op) throws Exception;
     public Carrera findByNombreCarreraID (Long id, String nombre)throws Exception;
     
     List<Carrera> findAllActivo();
     public  List<Carrera> findAllDepartamento (Long id)throws Exception;
}
