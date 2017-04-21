/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.AutoridadesDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface AutoridadesDepartamentoFacadeLocal {

    void create(AutoridadesDepartamento autoridadesDepartamento);

    void edit(AutoridadesDepartamento autoridadesDepartamento);

    void remove(AutoridadesDepartamento autoridadesDepartamento);

    AutoridadesDepartamento find(Object id);

    List<AutoridadesDepartamento> findAll();

    List<AutoridadesDepartamento> findRange(int[] range);

    int count();
    
    public AutoridadesDepartamento findAutoridades () throws Exception;
    
}
