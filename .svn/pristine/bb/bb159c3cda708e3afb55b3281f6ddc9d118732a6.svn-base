/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.NotaFinalAlumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface NotaFinalAlumnoFacadeLocal {

    void create(NotaFinalAlumno notaFinalAlumno);

    void edit(NotaFinalAlumno notaFinalAlumno);

    void remove(NotaFinalAlumno notaFinalAlumno);

    NotaFinalAlumno find(Object id);

    List<NotaFinalAlumno> findAll();

    List<NotaFinalAlumno> findRange(int[] range);

    int count();
    
}
