/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Profesional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProfesionalRNLocal {

    void create(Profesional pro) throws Exception;

    void remove(Profesional pro) throws Exception;

    void edit(Profesional pro) throws Exception;

    List<Profesional> findAll() throws Exception;

    public Profesional findByDni(Integer dni) throws Exception;

    public void activate(Profesional profesional, Boolean bEstado) throws Exception;
    
    List<Profesional> findAllActivo() throws Exception;

}
