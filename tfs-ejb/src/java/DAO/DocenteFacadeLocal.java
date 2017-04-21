/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Alumno;
import entidad.Depto;
import entidad.Docente;
import entidad.DocenteCatedra;
import entidad.DocenteDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface DocenteFacadeLocal {

    void create(Docente docente);

    void edit(Docente docente);

    void remove(Docente docente);

    Docente find(Object id);

    List<Docente> findAll();

    List<Docente> findRange(int[] range);

    int count();
    
    public Docente findByDocente(String dni) throws Exception;
    public void activate(Docente doc, Boolean bEstado);
    
    public List<Docente> findByDocenteTribunal(long pre, long voc1, long voc2, long sup1, long sup2) throws Exception;
    
    public Docente findById(Long id)  throws Exception;
    
    List<Docente> findAllActivo();
    
    public Boolean findByCuil(String cuil)  throws Exception;
    
     public Boolean bFindByDniDocente(Docente p, int op) throws Exception;
     
    public List<Docente> SeleccionarTodo() throws Exception;
    public  List<DocenteDepartamento> findAllDepartamento (Long id)throws Exception;
    
}
