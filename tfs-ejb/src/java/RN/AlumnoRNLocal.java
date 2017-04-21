/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Alumno;
import entidad.Depto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface AlumnoRNLocal {
    void create(Alumno p) throws Exception;

    void remove(Alumno p) throws Exception;

    void edit(Alumno p) throws Exception;

    List<Alumno> findAll() throws Exception;
    
    public Alumno findByAlumno(Integer matricula)  throws Exception;
    public void activate(Alumno al, Boolean bEstado) throws Exception;
    
    
}
