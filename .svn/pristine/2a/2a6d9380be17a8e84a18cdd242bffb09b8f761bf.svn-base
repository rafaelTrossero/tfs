/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.DocenteDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface DocenteDepartamentoRNLocal {
    
     void create(DocenteDepartamento p) throws Exception;

    void remove(DocenteDepartamento p) throws Exception;

    void edit(DocenteDepartamento p) throws Exception;

    List<DocenteDepartamento> findAll() throws Exception;
    
    
    public DocenteDepartamento findByDocente(DocenteDepartamento doc) throws Exception;
    
    public DocenteDepartamento findByIdDocente (long idDoc) throws Exception;
    
    public List<DocenteDepartamento> findDocentesbyComision (long idComision) throws Exception;
}
