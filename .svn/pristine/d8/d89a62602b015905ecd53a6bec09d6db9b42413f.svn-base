/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.AutoridadesDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface AutoridadesDepartamentoRNLocal {
    
       void create(AutoridadesDepartamento n) throws Exception;

    void remove(AutoridadesDepartamento n) throws Exception;

    void edit(AutoridadesDepartamento n) throws Exception;

    List<AutoridadesDepartamento> findAll() throws Exception;
    
     public void activate(AutoridadesDepartamento n, Boolean bEstado) throws Exception;
     
     public AutoridadesDepartamento findAutoridades () throws Exception;
     
}
