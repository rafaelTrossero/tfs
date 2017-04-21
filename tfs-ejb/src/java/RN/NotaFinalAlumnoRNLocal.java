/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.NotaFinalAlumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface NotaFinalAlumnoRNLocal {
    
      void create(NotaFinalAlumno p) throws Exception;

    void remove(NotaFinalAlumno p) throws Exception;

    void edit(NotaFinalAlumno p) throws Exception;

    List<NotaFinalAlumno> findAll() throws Exception;
    
}
