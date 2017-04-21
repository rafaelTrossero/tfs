/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Objetivos;
import entidad.Persona;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface ObjetivosRNLocal {

    void create(Objetivos p) throws Exception;

    void remove(Objetivos p) throws Exception;

    void edit(Objetivos p) throws Exception;

    List<Objetivos> findAll() throws Exception;
    
    public List<Objetivos> findObjGeneralByProyectoId (Proyecto proy) throws Exception;
    
    public List<Objetivos> findObjEspecificoslByProyectoId (Proyecto proy) throws Exception;
    
     List<Objetivos> findAllById(Proyecto proy) throws Exception;;
}