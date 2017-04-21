/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.ProfesionEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface ProfesionEspecialidadRNLocal {

    void create(ProfesionEspecialidad pro_esp) throws Exception;

    void remove(ProfesionEspecialidad pro_esp) throws Exception;

    void edit(ProfesionEspecialidad pro_esp) throws Exception;

    List<ProfesionEspecialidad> findAll() throws Exception;

}
