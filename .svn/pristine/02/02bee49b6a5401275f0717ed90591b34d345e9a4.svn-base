/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.ProyectoAlumno;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoAlumnoFacadeLocal {

    void create(ProyectoAlumno proy_alumno);

    void edit(ProyectoAlumno proy_alumno);

    void remove(ProyectoAlumno proy_alumno);

    ProyectoAlumno find(Object id);

    List<ProyectoAlumno> findAll();

    List<ProyectoAlumno> findRange(int[] range);

    int count();
    public List<ProyectoAlumno> findByProyAlumno(Proyecto pro) throws Exception;
    public ProyectoAlumno findByProyectoAlumno (long alu) throws Exception;
}
