/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.AlumnoCarrera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface AlumnoCarreraRNLocal {
    void create(AlumnoCarrera a) throws Exception;

    void remove(AlumnoCarrera a) throws Exception;

    void edit(AlumnoCarrera a) throws Exception;

    List<AlumnoCarrera> findAll() throws Exception;  
    public AlumnoCarrera findByAlumno(AlumnoCarrera alu)  throws Exception;
    public AlumnoCarrera findByAlumnoCarrera(Long idAlu,long idCar)  throws Exception;
    public List<AlumnoCarrera> findAlumnoCarrera(AlumnoCarrera alu_car) throws Exception;
}
