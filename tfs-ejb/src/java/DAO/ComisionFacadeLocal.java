/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Carrera;
import entidad.Comision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface ComisionFacadeLocal {

    void create(Comision comision);

    void edit(Comision comision);

    void remove(Comision comision);

    Comision find(Object id);

    List<Comision> findAll();

    List<Comision> findRange(int[] range);
    
    public void activate(Comision c, Boolean bEstado) throws Exception;
    
    public Boolean findByComisionName(Comision c, int op) throws Exception;

    int count();
    
    List<Comision> findAllActivo();
}
