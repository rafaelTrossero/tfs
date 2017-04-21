/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Provincia;
import entidad.ProyectoAlumno;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoAlumnoRNLocal {

    void create(ProyectoAlumno alu) throws Exception;

    void remove(ProyectoAlumno alu) throws Exception;

    void edit(ProyectoAlumno alu) throws Exception;

    List<ProyectoAlumno> findAll() throws Exception;

    public List<ProyectoAlumno> findByProyAlumno(Proyecto pro) throws Exception;
    
    public ProyectoAlumno findByProyectoAlumno(long alu) throws Exception;
}
