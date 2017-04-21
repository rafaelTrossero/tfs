/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Comision;
import entidad.Depto;
import entidad.Docente;
import entidad.DocenteComision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface DocenteComisionFacadeLocal {

    void create(DocenteComision docente_Comision);

    void edit(DocenteComision docente_Comision);

    void remove(DocenteComision docente_Comision);

    DocenteComision find(Object id);

    List<DocenteComision> findAll();

    List<DocenteComision> findRange(int[] range);

    int count();
    
    public DocenteComision findByDocente(DocenteComision doc) throws Exception;
    
     public List<Docente> findDocentesbyComision (long idComision) throws Exception;
  
    public Comision findByIdDocente (long idDoc) throws Exception;
}
