/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.ProfesionEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface ProfesionEspecialidadFacadeLocal {

    void create(ProfesionEspecialidad profesion_Especialidad);

    void edit(ProfesionEspecialidad profesion_Especialidad);

    void remove(ProfesionEspecialidad profesion_Especialidad);

    ProfesionEspecialidad find(Object id);

    List<ProfesionEspecialidad> findAll();

    List<ProfesionEspecialidad> findRange(int[] range);

    int count();

}
