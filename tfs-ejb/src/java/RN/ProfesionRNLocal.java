/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Profesion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface ProfesionRNLocal {

    void create(Profesion p) throws Exception;

    void remove(Profesion p) throws Exception;

    void edit(Profesion p) throws Exception;

    List<Profesion> findAll() throws Exception;

}
