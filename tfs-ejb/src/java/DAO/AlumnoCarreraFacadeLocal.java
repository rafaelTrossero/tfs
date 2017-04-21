/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.AlumnoCarrera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface AlumnoCarreraFacadeLocal {

    void create(AlumnoCarrera alumno_Carrera);

    void edit(AlumnoCarrera alumno_Carrera);

    void remove(AlumnoCarrera alumno_Carrera);

    AlumnoCarrera find(Object id);

    List<AlumnoCarrera> findAll();

    List<AlumnoCarrera> findRange(int[] range);

    int count();
    public AlumnoCarrera findByAlumno(AlumnoCarrera alu) throws Exception;
    public AlumnoCarrera findByAlumnoCarrera(Long idAlu,Long idCar) throws Exception;
    public List<AlumnoCarrera> findAlumnoCarrera(AlumnoCarrera alu_car) throws Exception;
}
