/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.DocenteDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface DocenteDepartamentoFacadeLocal {

    void create(DocenteDepartamento docenteDepartamento);

    void edit(DocenteDepartamento docenteDepartamento);

    void remove(DocenteDepartamento docenteDepartamento);

    DocenteDepartamento find(Object id);

    List<DocenteDepartamento> findAll();

    List<DocenteDepartamento> findRange(int[] range);

    int count();
    
}
